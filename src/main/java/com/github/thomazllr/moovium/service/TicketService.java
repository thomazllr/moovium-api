package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.entity.Ticket;
import com.github.thomazllr.moovium.repository.SessionRepository;
import com.github.thomazllr.moovium.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    private TicketRepository repository;

    private SessionRepository sessionRepository;

    public TicketService(TicketRepository repository, SessionRepository sessionRepository) {
        this.repository = repository;
        this.sessionRepository = sessionRepository;
    }

    public Ticket findById(String id) {
        return repository.findById(UUID.fromString(id)).orElse(null);
    }

    public List<Ticket> findAll() {
        return repository.findAll();
    }
}
