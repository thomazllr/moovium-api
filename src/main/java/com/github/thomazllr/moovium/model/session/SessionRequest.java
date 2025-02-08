package com.github.thomazllr.moovium.model.session;

import com.github.thomazllr.moovium.model.movie.Movie;

import java.time.LocalDateTime;

public record SessionRequest(
        String movie,
        LocalDateTime sessionTime,
        String theaterName) {

    public Session toSession(Movie movie) {
        Session session = new Session();
        session.setMovie(movie);
        session.setSessionTime(sessionTime);
        return session;
    }
}
