package com.github.thomazllr.moovium.controller;

import com.github.thomazllr.moovium.entity.Movie;
import com.github.thomazllr.moovium.entity.dto.movie.MovieRequest;
import com.github.thomazllr.moovium.entity.dto.movie.MovieResponse;
import com.github.thomazllr.moovium.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static com.github.thomazllr.moovium.util.UriUtil.generateHeaderLocation;

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
        URI location = generateHeaderLocation(movie.getId());
        return ResponseEntity.created(location).body(MovieResponse.toResponse(movie));
    }

    @GetMapping
    public ResponseEntity<Page<MovieResponse>> getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                      @RequestParam(value = "size", defaultValue = "10") Integer size) {
        var movieList = service.findAll(page, size);
        Page<MovieResponse> pageableMovieResponse = movieList.map(MovieResponse::toResponse);
        return ResponseEntity.ok(pageableMovieResponse);
    }


}
