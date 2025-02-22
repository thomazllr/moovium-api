package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.entity.Session;
import com.github.thomazllr.moovium.mapper.SessionMapper;
import com.github.thomazllr.moovium.entity.dto.session.SessionRequest;
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

    public Session create(SessionRequest request) {
        var session = SessionMapper.fromRequest(request);
        validator.validator(session);
        return repository.save(session);
    }

    public List<Session> findAll() {
        return repository.findAll();
    }
}
