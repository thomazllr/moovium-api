package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.entity.Session;
import com.github.thomazllr.moovium.repository.SessionRepository;
import com.github.thomazllr.moovium.validator.SessionValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {

    final private SessionRepository repository;

    final private SessionValidator validator;

    public Session create(Session request) {
        validator.validator(request);
        return repository.save(request);
    }

    public List<Session> findAll() {
        return repository.findAll();
    }
}
