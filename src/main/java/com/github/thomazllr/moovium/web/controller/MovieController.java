package com.github.thomazllr.moovium.web.controller;

import com.github.thomazllr.moovium.entity.Movie;
import com.github.thomazllr.moovium.web.dto.movie.MovieRequest;
import com.github.thomazllr.moovium.web.dto.movie.MovieResponse;
import com.github.thomazllr.moovium.service.MovieService;
import com.github.thomazllr.moovium.web.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static com.github.thomazllr.moovium.util.UriUtil.generateHeaderLocation;

@RequiredArgsConstructor
@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService service;
    private final MovieMapper mapper;

    @PostMapping
    public ResponseEntity<MovieResponse> save(@RequestBody MovieRequest request) {
        var movie = service.create(mapper.toEntity(request));
        URI location = generateHeaderLocation(movie.getId());
        return ResponseEntity.created(location).body(mapper.toResponse(movie));
    }

    @GetMapping
    public ResponseEntity<Page<MovieResponse>> getAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                      @RequestParam(value = "size", defaultValue = "10") Integer size) {
        var movieList = service.findAll(page, size);
        Page<MovieResponse> pageableMovieResponse = movieList.map(mapper::toResponse);
        return ResponseEntity.ok(pageableMovieResponse);
    }


}
