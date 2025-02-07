package com.github.thomazllr.moovium.model.dto.session;

import com.github.thomazllr.moovium.model.Movie;
import com.github.thomazllr.moovium.model.Session;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record SessionRequest(
        String movie,
        LocalDateTime sessionTime,
        String theaterName) {

    public Session toSession(Movie movie) {
        Session session = new Session();
        session.setMovie(movie);
        session.setSessionTime(sessionTime);
        session.setTheaterName(theaterName);
        return session;
    }
}
