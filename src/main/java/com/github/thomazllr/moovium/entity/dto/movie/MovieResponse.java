package com.github.thomazllr.moovium.entity.dto.movie;

import com.github.thomazllr.moovium.entity.Movie;
import com.github.thomazllr.moovium.entity.Genre;

import java.time.LocalDate;
import java.util.UUID;

public record MovieResponse(UUID id, String title, Genre genre, LocalDate releaseDate, Integer duration) {

    public static MovieResponse toResponse(Movie movie) {
        return new MovieResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getGenre(),
                movie.getReleaseDate(),
                movie.getDuration());
    }
}
