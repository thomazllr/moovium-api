package com.github.thomazllr.moovium.web.controller;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.web.dto.seat.SeatRequest;
import com.github.thomazllr.moovium.web.dto.seat.SeatResponse;
import com.github.thomazllr.moovium.service.SeatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import static com.github.thomazllr.moovium.util.UriUtil.generateHeaderLocation;


@RequiredArgsConstructor
@RestController
@RequestMapping("/seat")
public class SeatController {

    private final SeatService service;

    @PostMapping
    public ResponseEntity<SeatResponse> saveSeat(@RequestBody @Valid SeatRequest request) {
        Seat seat = service.create(request);
        URI location = generateHeaderLocation(seat.getId());
        return ResponseEntity.created(location).body(SeatResponse.toResponse(seat));
    }

    @GetMapping
    public ResponseEntity<List<SeatResponse>> getSeats() {
        return ResponseEntity.ok(service.findAll().stream().map(SeatResponse::toResponse).toList());
    }

}
