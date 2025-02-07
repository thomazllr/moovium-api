package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.exceptions.MovieNotFoundException;
import com.github.thomazllr.moovium.model.Session;
import com.github.thomazllr.moovium.model.dto.session.SessionRequest;
import com.github.thomazllr.moovium.repository.MovieRepository;
import com.github.thomazllr.moovium.repository.SessionRepository;
import com.github.thomazllr.moovium.validator.SessionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SessionService {

    private SessionRepository repository;
    private MovieRepository movieRepository;
    private SessionValidator validator;

    @Autowired
    public SessionService(SessionRepository repository, MovieRepository movieRepository, SessionValidator validator) {
        this.repository = repository;
        this.movieRepository = movieRepository;
        this.validator = validator;
    }



    public Session create(SessionRequest request) {
        var movie = movieRepository.findById
                (UUID.fromString(request.movie())).orElseThrow(() ->
                new MovieNotFoundException("The movie was not found."));
        var session = request.toSession(movie);
        validator.validator(session);
        return repository.save(session);
    }

    public List<Session> findAll() {
        return repository.findAll();
    }
}
