package com.github.thomazllr.moovium.model.dto.movie;

import com.github.thomazllr.moovium.model.Genre;
import com.github.thomazllr.moovium.model.Movie;

import java.time.LocalDate;

public record MovieResponse(String title, Genre genre, LocalDate releaseDate) {
    public MovieResponse(Movie movie) {
        this(movie.getTitle(), movie.getGenre(), movie.getReleaseDate());
    }
}
