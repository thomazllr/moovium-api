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
        if(!isAvailable(session.getMovie())) {
            throw new RuntimeException("Não tem como cadastrar chefe, já tem 3!");
        }
    }

    public boolean isAvailable(Movie movie) {
        return sessionRepository.countByMovie(movie) < 3;
    }
}
