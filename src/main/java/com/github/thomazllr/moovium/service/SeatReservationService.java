package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.SeatReservation;
import com.github.thomazllr.moovium.entity.Session;
import com.github.thomazllr.moovium.entity.Status;
import com.github.thomazllr.moovium.entity.dto.seat.reservation.SeatReservationRequest;
import com.github.thomazllr.moovium.repository.SeatRepository;
import com.github.thomazllr.moovium.repository.SeatReservationRepository;
import com.github.thomazllr.moovium.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SeatReservationService {


    private SeatReservationRepository reservationRepository;
    private SessionRepository sessionRepository;
    private SeatRepository seatRepository;

    public SeatReservationService(SeatReservationRepository reservationRepository, SessionRepository sessionRepository, SeatRepository seatRepository) {
        this.reservationRepository = reservationRepository;
        this.sessionRepository = sessionRepository;
        this.seatRepository = seatRepository;
    }

    public SeatReservation save(SeatReservationRequest request) {
        Session session = sessionRepository.findById(UUID.fromString(request.session())).orElseThrow(() -> new RuntimeException("session not found"));
        Seat seat = seatRepository.findById(UUID.fromString(request.seat())).orElseThrow(() -> new RuntimeException("seat not found"));
        SeatReservation reservation = new SeatReservation();
        reservation.setSeat(seat);
        reservation.setSession(session);
        reservation.setStatus(Status.SOLD);
        return reservationRepository.save(reservation);
    }
}
