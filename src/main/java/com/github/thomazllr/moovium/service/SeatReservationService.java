package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.entity.*;
import com.github.thomazllr.moovium.web.dto.seat.reservation.SeatReservationRequest;
import com.github.thomazllr.moovium.repository.SeatRepository;
import com.github.thomazllr.moovium.repository.SeatReservationRepository;
import com.github.thomazllr.moovium.repository.SessionRepository;
import com.github.thomazllr.moovium.repository.TicketRepository;
import com.github.thomazllr.moovium.validator.SeatReservationValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SeatReservationService {

    final private SeatReservationRepository reservationRepository;
    final private SessionRepository sessionRepository;
    final private SeatRepository seatRepository;
    final private TicketRepository ticketRepository;
    final private QrCodeService qrCodeService;
    final private SeatReservationValidator validator;


    @Transactional
    public SeatReservation reserve(SeatReservationRequest request) {
        Session session = sessionRepository.findById(UUID.fromString(request.session())).orElseThrow(() -> new RuntimeException("session not found"));
        Seat seat = seatRepository.findById(UUID.fromString(request.seat())).orElseThrow(() -> new RuntimeException("seat not found"));
        SeatReservation reservation = new SeatReservation();
        reservation.setSeat(seat);
        reservation.setSession(session);
        reservation.setStatus(Status.RESERVED);
        reservation.setReservationExpiration(LocalDateTime.now().plusMinutes(10));
        validator.validate(reservation);
        return reservationRepository.save(reservation);
    }

    @Transactional
    public SeatReservation confirmPurchase(String reservationId) {
        SeatReservation reservation = reservationRepository.findById(UUID.fromString(reservationId))
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        if (reservation.getStatus() != Status.RESERVED) {
            throw new RuntimeException("Seat is not in RESERVED status");
        }

        if (reservation.getReservationExpiration().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Reservation expired");
        }

        Ticket ticket = Ticket.builder()
                .seatReservation(reservation)
                .price(new BigDecimal("50.00"))
                .qrCode("qrcode123")
                .build();
        ticket = ticketRepository.save(ticket);
        ticket.setQrCode(qrCodeService.generateQRCode(ticket.getId()));

        reservation.setStatus(Status.SOLD);
        return reservationRepository.save(reservation);
    }

    @Transactional
    @Scheduled(fixedRate = 60000)
    public void cleanExpiredReservations() {
        if (reservationRepository.countAll() > 0)
            reservationRepository.deleteExpiredReservations();
    }

    public List<SeatReservation> findAll() {
        return reservationRepository.findAll();
    }

    public List<SeatReservation> getReservationsForSession(String id) {
        Session session = sessionRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Session not found"));
        return reservationRepository.findBySession(session);
    }
}
