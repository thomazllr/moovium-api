package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.entity.Movie;
import com.github.thomazllr.moovium.entity.dto.movie.MovieRequest;
import com.github.thomazllr.moovium.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Movie create(MovieRequest request) {
        return repository.save(request.toMovie());
    }


    public Page<Movie> findAll(Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return repository.findAll(pageRequest);
    }
}
