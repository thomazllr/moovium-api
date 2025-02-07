package com.github.thomazllr.moovium.model.dto.movie;

import com.github.thomazllr.moovium.model.Genre;
import com.github.thomazllr.moovium.model.Movie;
import com.github.thomazllr.moovium.model.Session;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record MovieResponse(UUID id, String title, Genre genre, LocalDate releaseDate, List<Session> sesseions) {
    public MovieResponse(Movie movie) {
        this(movie.getId(), movie.getTitle(), movie.getGenre(), movie.getReleaseDate(), movie.getSessions());
    }
}
