package com.github.thomazllr.moovium.controller;

import com.github.thomazllr.moovium.model.movie.Movie;
import com.github.thomazllr.moovium.model.movie.MovieRequest;
import com.github.thomazllr.moovium.model.movie.MovieResponse;
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
        Movie movie = service.create(request);
        URI location = URI.create("/movie/" + movie.getId());
        return ResponseEntity.created(location).body(MovieResponse.toResponse(movie));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }


}
