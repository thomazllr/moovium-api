package com.github.thomazllr.moovium.model.dto.movie;

import com.github.thomazllr.moovium.model.Genre;
import com.github.thomazllr.moovium.model.Movie;

import java.time.LocalDate;
import java.util.UUID;

public record MovieResponse(UUID id, String title, Genre genre, LocalDate releaseDate) {
    public MovieResponse(Movie movie) {
        this(movie.getId(), movie.getTitle(), movie.getGenre(), movie.getReleaseDate());
    }
}
