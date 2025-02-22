package com.github.thomazllr.moovium.entity.dto.movie;

import com.github.thomazllr.moovium.entity.Movie;
import com.github.thomazllr.moovium.entity.Genre;
import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;

@Builder
public record MovieResponse(UUID id, String title, Genre genre, LocalDate releaseDate, Integer duration) {

    public static MovieResponse toResponse(Movie movie) {
        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .genre(movie.getGenre())
                .releaseDate(movie.getReleaseDate())
                .duration(movie.getDuration())
                .build();
    }
}
