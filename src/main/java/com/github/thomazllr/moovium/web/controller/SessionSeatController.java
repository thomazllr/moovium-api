package com.github.thomazllr.moovium.web.controller;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.SeatReservation;
import com.github.thomazllr.moovium.entity.Status;
import com.github.thomazllr.moovium.web.dto.seat.SeatStatusDTO;
import com.github.thomazllr.moovium.service.SessionSeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/session")
public class SessionSeatController {

    private final SessionSeatService service;

    @GetMapping("/{sessionId}/seats")
    public ResponseEntity<List<SeatStatusDTO>> findAllSeatsBySession(@PathVariable String sessionId) {
        List<Seat> seats = service.getSeatsForSession(sessionId);
        List<SeatReservation> reservations = service.getsSeatsReservationForSession(sessionId);

        Map<Seat, SeatReservation> reservationBySeat = reservations.stream()
                .collect(Collectors.toMap(SeatReservation::getSeat, reservation -> reservation));

        List<SeatStatusDTO> seatStatusDTOS = seats.stream().map(seat ->  {
           var seatNumber = seat.getSeatNumber();
           var seatRow = seat.getRow();
           var reservation = reservationBySeat.get(seat);
           return Optional.ofNullable(reservation).map(r -> new SeatStatusDTO(seatNumber, seatRow, r.getStatus())).orElseGet(() -> new SeatStatusDTO(seatNumber, seatRow, Status.AVAILABLE));
        }).toList();

        return ResponseEntity.ok(seatStatusDTOS);
    }
}
