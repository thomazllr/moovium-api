package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.model.Ticket;
import com.github.thomazllr.moovium.model.dto.ticket.TicketRequest;
import com.github.thomazllr.moovium.repository.SessionRepository;
import com.github.thomazllr.moovium.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class TicketService {

    private TicketRepository repository;

    private SessionRepository sessionRepository;

    @Autowired
    public TicketService(TicketRepository repository, SessionRepository sessionRepository) {
        this.repository = repository;
        this.sessionRepository = sessionRepository;
    }

    @Transactional
    public Ticket create(TicketRequest request) {
        var session = sessionRepository
                .findById(UUID.fromString(request.session())).orElseThrow(
                () -> new IllegalArgumentException("Session not found"));
        var ticket = request.toTicket(session);
        ticket.setSold(true);
        ticket.setQrCode(UUID.randomUUID().toString());
        session.setSeatsAvailable(session.getSeatsAvailable() - 1);
        sessionRepository.save(session);
        return repository.save(ticket);
    }

    public List<Ticket> findAll() {
        return repository.findAll();
    }
}
