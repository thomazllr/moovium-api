package com.github.thomazllr.moovium.controller;

import com.github.thomazllr.moovium.model.dto.movie.MovieRequest;
import com.github.thomazllr.moovium.model.dto.movie.MovieResponse;
import com.github.thomazllr.moovium.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MovieResponse> save(@RequestBody MovieRequest request) {
        var savedMovie = service.create(request);
        URI location = URI.create("/movies/" + savedMovie.getId());
        return ResponseEntity.created(location).body(new MovieResponse(savedMovie));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
