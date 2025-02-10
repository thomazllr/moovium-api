package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.exceptions.MovieNotFoundException;
import com.github.thomazllr.moovium.exceptions.TheaterNotFoundException;
import com.github.thomazllr.moovium.entity.Session;
import com.github.thomazllr.moovium.model.session.SessionRequest;
import com.github.thomazllr.moovium.repository.MovieRepository;
import com.github.thomazllr.moovium.repository.SessionRepository;
import com.github.thomazllr.moovium.repository.TheaterRepository;
import com.github.thomazllr.moovium.validator.SessionValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SessionService {

    private SessionRepository repository;
    private MovieRepository movieRepository;
    private TheaterRepository theaterRepository;
    private SessionValidator validator;

    public SessionService(SessionRepository repository, MovieRepository movieRepository, TheaterRepository theaterRepository, SessionValidator validator) {
        this.repository = repository;
        this.movieRepository = movieRepository;
        this.theaterRepository = theaterRepository;
        this.validator = validator;
    }

    public Session create(SessionRequest request) {
        var movie = movieRepository.findById
                (UUID.fromString(request.movie())).orElseThrow(() ->
                new MovieNotFoundException("The movie was not found."));
        var theater = theaterRepository.findById(UUID.fromString(request.theater())).orElseThrow(() -> new TheaterNotFoundException("The Theater was not found")) ;
        var session = request.toSession(movie, theater);
        validator.validator(session);
        return repository.save(session);
    }

    public List<Session> findAll() {
        return repository.findAll();
    }
}
