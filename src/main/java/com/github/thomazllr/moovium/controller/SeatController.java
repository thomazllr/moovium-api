package com.github.thomazllr.moovium.controller;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.model.seat.SeatRequest;
import com.github.thomazllr.moovium.service.SeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seat")
public class SeatController {

    private SeatService service;

    public SeatController(SeatService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Seat> saveSeat(@RequestBody SeatRequest request) {
        Seat seat = service.create(request);
        return ResponseEntity.ok(seat);
    }
}
