package com.github.thomazllr.moovium.model.dto.movie;

import com.github.thomazllr.moovium.model.Genre;
import com.github.thomazllr.moovium.model.Movie;
import com.github.thomazllr.moovium.model.dto.session.SessionResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record MovieResponse(UUID id, String title, Genre genre, LocalDate releaseDate, Integer duration,
                            List<SessionResponse> sessions) {

    public static MovieResponse toResponse(Movie movie) {
        if (movie.getSessions() == null) {
            movie.setSessions(new ArrayList<>());
        }
        return new MovieResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getGenre(),
                movie.getReleaseDate(),
                movie.getDuration(),
                movie.getSessions().stream().map(SessionResponse::toResponse).toList());

    }

}
