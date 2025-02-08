package com.github.thomazllr.moovium.repository;

import com.github.thomazllr.moovium.model.ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
}
