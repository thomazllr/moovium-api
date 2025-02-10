package com.github.thomazllr.moovium.controller;

import com.github.thomazllr.moovium.entity.dto.seat.reservation.SeatReservationRequest;
import com.github.thomazllr.moovium.entity.dto.seat.reservation.SeatReservationResponse;
import com.github.thomazllr.moovium.service.SeatReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/reservation")
public class SeatReservationController {

    public SeatReservationService service;

    public SeatReservationController(SeatReservationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SeatReservationResponse> save(@RequestBody SeatReservationRequest seatReservationRequest) {
        var reservation = service.save(seatReservationRequest);
        URI location = URI.create("/reservation/" + reservation.getId());
        return ResponseEntity.created(location).body(SeatReservationResponse.toResponse(reservation));

    }
}
