package com.github.thomazllr.moovium.controller;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.dto.seat.SeatRequest;
import com.github.thomazllr.moovium.entity.dto.seat.SeatResponse;
import com.github.thomazllr.moovium.service.SeatService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/seat")
public class SeatController {

    private SeatService service;

    public SeatController(SeatService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SeatResponse> saveSeat(@RequestBody @Valid SeatRequest request) {
        Seat seat = service.create(request);
        URI location = URI.create("/seat/" + seat.getId());
        return ResponseEntity.created(location).body(SeatResponse.toResponse(seat));
    }

    @GetMapping
    public ResponseEntity<List<SeatResponse>> getSeats() {
        return ResponseEntity.ok(service.findAll().stream().map(SeatResponse::toResponse).toList());
    }
}
