package com.github.thomazllr.moovium.validator;

import com.github.thomazllr.moovium.model.Movie;
import com.github.thomazllr.moovium.model.Session;
import com.github.thomazllr.moovium.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionValidator {

    @Autowired
    private SessionRepository sessionRepository;

    public void validator(Session session) {
        if (!isAvailable(session.getMovie())) {
            throw new RuntimeException("It is not possible to register, as there are already three sessions recorded.");
        }
        if (sessionExists(session)) {
            throw new RuntimeException("There is already a session scheduled at this time for this theater.");
        }
    }

    public boolean isAvailable(Movie movie) {
        return sessionRepository.countByMovie(movie) < 3;
    }

    public boolean sessionExists(Session session) {
        return sessionRepository.existsBySessionTimeAndTheaterName(session.getSessionTime(), session.getTheaterName());
    }
}
