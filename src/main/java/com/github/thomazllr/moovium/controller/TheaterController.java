package com.github.thomazllr.moovium.controller;

import com.github.thomazllr.moovium.entity.dto.theater.TheaterRequest;
import com.github.thomazllr.moovium.entity.dto.theater.TheaterResponse;
import com.github.thomazllr.moovium.service.TheaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

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
        URI location = URI.create("/theater/" + theater.getId());
        return ResponseEntity.created(location).body(TheaterResponse.toResponse(theater));
    }
}
