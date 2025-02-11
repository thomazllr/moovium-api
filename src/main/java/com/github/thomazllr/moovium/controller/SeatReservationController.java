package com.github.thomazllr.moovium.controller;

import com.github.thomazllr.moovium.entity.dto.seat.reservation.SeatReservationRequest;
import com.github.thomazllr.moovium.entity.dto.seat.reservation.SeatReservationResponse;
import com.github.thomazllr.moovium.service.SeatReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static com.github.thomazllr.moovium.util.UriUtil.generateHeaderLocation;

@RestController
@RequestMapping("/reservation")
public class SeatReservationController {

    public SeatReservationService service;

    public SeatReservationController(SeatReservationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SeatReservationResponse> reserve(@RequestBody SeatReservationRequest seatReservationRequest) {
        var reservation = service.reserve(seatReservationRequest);
        URI location = generateHeaderLocation(reservation.getId());
        return ResponseEntity.created(location).body(SeatReservationResponse.toResponse(reservation));
    }

    @GetMapping
    public ResponseEntity<List<SeatReservationResponse>> getAll() {
        return ResponseEntity.ok(service.findAll().stream().map(SeatReservationResponse::toResponse).toList());
    }

}
