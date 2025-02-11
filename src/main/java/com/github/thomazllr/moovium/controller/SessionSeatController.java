package com.github.thomazllr.moovium.controller;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.SeatReservation;
import com.github.thomazllr.moovium.entity.dto.seat.SeatStatusDTO;
import com.github.thomazllr.moovium.service.SessionSeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SessionSeatController {

    private SessionSeatService service;

    public SessionSeatController(SessionSeatService service) {
        this.service = service;
    }

    @GetMapping("{sessionId}/seats")
    public ResponseEntity<List<SeatStatusDTO>> findAllSeatsBySession(@PathVariable String sessionId) {

        List<Seat> seats = service.getSeatsForSession(sessionId);
        List<SeatReservation> reservations = service.getsSeatsReservationForSession(sessionId);

        seats.stream().map(seat ->  {
            new SeatStatusDTO(seat.getSeatNumber(), seat.getSeatNumber(), reservations.stream().findFirst().get().getStatus())
        });


        return ResponseEntity.ok().build();
    }
}
