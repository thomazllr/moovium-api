package com.github.thomazllr.moovium.web.controller;

import com.github.thomazllr.moovium.validator.TheaterValidator;
import com.github.thomazllr.moovium.web.dto.theater.TheaterRequest;
import com.github.thomazllr.moovium.web.dto.theater.TheaterResponse;
import com.github.thomazllr.moovium.service.TheaterService;
import com.github.thomazllr.moovium.web.mapper.TheaterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static com.github.thomazllr.moovium.util.UriUtil.generateHeaderLocation;

@RequiredArgsConstructor
@RestController
@RequestMapping("/theater")
public class TheaterController {

    private final TheaterService service;
    private final TheaterMapper mapper;

    @PostMapping
    ResponseEntity<TheaterResponse> save(@RequestBody TheaterRequest request) {
        var theater = service.create(mapper.toEntity(request));
        URI location = generateHeaderLocation(theater.getId());
        return ResponseEntity.created(location).body(mapper.toResponse(theater));
    }

    @GetMapping
    ResponseEntity<List<TheaterResponse>> findAll() {
        return ResponseEntity.ok(service.findAll().stream().map(mapper::toResponse).toList());
    }
}
