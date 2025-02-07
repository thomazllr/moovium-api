package com.github.thomazllr.moovium.model.dto.ticket;

import com.github.thomazllr.moovium.model.Session;
import com.github.thomazllr.moovium.model.Ticket;

import java.math.BigDecimal;
import java.util.UUID;

public record TicketRequest(String session, String seatNumber, BigDecimal price) {

    public Ticket toTicket(Session session) {
        Ticket ticket = new Ticket();
        ticket.setSeatNumber(seatNumber);
        ticket.setPrice(price);
        ticket.setSession(session);
        return ticket;
    }
}
