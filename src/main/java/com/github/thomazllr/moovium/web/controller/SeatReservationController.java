package com.github.thomazllr.moovium.web.controller;

import com.github.thomazllr.moovium.web.dto.seat.reservation.SeatReservationRequest;
import com.github.thomazllr.moovium.web.dto.seat.reservation.SeatReservationResponse;
import com.github.thomazllr.moovium.service.SeatReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static com.github.thomazllr.moovium.util.UriUtil.generateHeaderLocation;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reservation")
public class SeatReservationController {

    private final SeatReservationService service;

    @PostMapping
    public ResponseEntity<SeatReservationResponse> reserve(@RequestBody SeatReservationRequest seatReservationRequest) {
        var reservation = service.reserve(seatReservationRequest);
        URI location = generateHeaderLocation(reservation.getId());
        return ResponseEntity.created(location).body(SeatReservationResponse.toResponse(reservation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeatReservationResponse> confirm(@PathVariable String id) {
        return ResponseEntity.ok(SeatReservationResponse.toResponse(service.confirmPurchase(id)));
    }

    @GetMapping
    public ResponseEntity<List<SeatReservationResponse>> getAll() {
        return ResponseEntity.ok(service.findAll().stream().map(SeatReservationResponse::toResponse).toList());
    }

}
