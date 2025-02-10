package com.github.thomazllr.moovium.entity.dto.session;

import com.github.thomazllr.moovium.entity.Movie;
import com.github.thomazllr.moovium.entity.Session;
import com.github.thomazllr.moovium.entity.Theater;

import java.time.LocalDateTime;
import java.util.ArrayList;

public record SessionRequest(
        String movie,
        LocalDateTime sessionTime,
        String theater) {

    public Session toSession(Movie movie, Theater theater) {
        Session session = new Session();
        session.setMovie(movie);
        session.setSessionTime(sessionTime);
        session.setTheater(theater);
        session.setReservations(new ArrayList<>());
        return session;
    }
}
