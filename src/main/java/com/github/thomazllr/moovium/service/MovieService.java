package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.entity.Movie;
import com.github.thomazllr.moovium.web.dto.movie.MovieRequest;
import com.github.thomazllr.moovium.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private static final Logger log = LoggerFactory.getLogger(MovieService.class);

    private final MovieRepository repository;

    public Movie create(Movie movie) {
        log.info("Creating a new movie");
        return repository.save(movie);
    }

    public Page<Movie> findAll(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return repository.findAll(pageRequest);
    }
}
