package com.github.thomazllr.moovium.controller;

import com.github.thomazllr.moovium.entity.Theater;
import com.github.thomazllr.moovium.entity.dto.theater.TheaterRequest;
import com.github.thomazllr.moovium.entity.dto.theater.TheaterResponse;
import com.github.thomazllr.moovium.service.TheaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static com.github.thomazllr.moovium.util.UriUtil.generateHeaderLocation;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    private TheaterService service;

    public TheaterController(TheaterService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<TheaterResponse> save(@RequestBody TheaterRequest request) {
        var theater = service.create(request);
        URI location = generateHeaderLocation(theater.getId());
        return ResponseEntity.created(location).body(TheaterResponse.toResponse(theater));
    }

    @GetMapping
    ResponseEntity<List<TheaterResponse>> findAll() {
        return ResponseEntity.ok(service.findAll().stream().map(TheaterResponse::toResponse).toList());
    }
}
