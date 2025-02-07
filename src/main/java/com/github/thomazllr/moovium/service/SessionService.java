package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.model.Session;
import com.github.thomazllr.moovium.model.dto.session.SessionRequest;
import com.github.thomazllr.moovium.repository.MovieRepository;
import com.github.thomazllr.moovium.repository.SessionRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SessionService {

    private SessionRepository repository;
    private MovieRepository movieRepository;

    @Autowired
    public SessionService(MovieRepository movieRepository, SessionRepository repository) {
        this.movieRepository = movieRepository;
        this.repository = repository;
    }

    public Session create(SessionRequest request) throws BadRequestException {
        var movie = movieRepository.findById
                (UUID.fromString(request.movie())).orElseThrow(() ->
                new BadRequestException(" nao encontrei teu filme"));

        return repository.save(request.toSession(movie));
    }

    public List<Session> findAll() {
        return repository.findAll();
    }
}
