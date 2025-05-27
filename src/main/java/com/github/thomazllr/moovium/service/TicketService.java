package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.entity.Ticket;
import com.github.thomazllr.moovium.repository.SessionRepository;
import com.github.thomazllr.moovium.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository repository;

    private final SessionRepository sessionRepository;

    public Ticket findById(String id) {
        return repository.findById(UUID.fromString(id)).orElse(null);
    }

    public List<Ticket> findAll() {
        return repository.findAll();
    }
}
