package com.github.thomazllr.moovium.controller;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.SeatReservation;
import com.github.thomazllr.moovium.entity.Status;
import com.github.thomazllr.moovium.entity.dto.seat.SeatStatusDTO;
import com.github.thomazllr.moovium.service.SessionSeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/session")
public class SessionSeatController {

    private SessionSeatService service;

    public SessionSeatController(SessionSeatService service) {
        this.service = service;
    }

    @GetMapping("/{sessionId}/seats")
    public ResponseEntity<List<SeatStatusDTO>> findAllSeatsBySession(@PathVariable String sessionId) {
        List<Seat> seats = service.getSeatsForSession(sessionId);
        List<SeatReservation> reservations = service.getsSeatsReservationForSession(sessionId);

        List<SeatStatusDTO> seatStatusDTOS = seats.stream().map(seat ->  {
           var seatNumber = seat.getSeatNumber();
           var seatRow = seat.getRow();
            Optional<SeatReservation> reservation = reservations.stream()
                    .filter(r -> r.getSeat().equals(seat))
                    .findFirst();
            return reservation.map(seatReservation -> new SeatStatusDTO(seatNumber, seatRow, seatReservation.getStatus())).orElseGet(() -> new SeatStatusDTO(seatNumber, seatRow, Status.AVAILABLE));
        }).toList();

        return ResponseEntity.ok(seatStatusDTOS);
    }
}
