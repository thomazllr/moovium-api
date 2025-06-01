package com.github.thomazllr.moovium.web.controller;

import com.github.thomazllr.moovium.service.SessionSeatService;
import com.github.thomazllr.moovium.web.dto.seat.SeatStatusDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/session")
public class SessionSeatController {

    private final SessionSeatService service;

    @GetMapping("/{sessionId}/seats")
    public ResponseEntity<List<SeatStatusDTO>> findAllSeatsBySession(@PathVariable String sessionId) {
        var seatStatusDTOS = service.getSeatStatusesForSession(sessionId);
        return ResponseEntity.ok(seatStatusDTOS);
    }
}
