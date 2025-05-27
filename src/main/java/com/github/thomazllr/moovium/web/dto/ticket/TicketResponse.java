package com.github.thomazllr.moovium.web.dto.ticket;

import com.github.thomazllr.moovium.entity.Ticket;

import java.math.BigDecimal;

public record TicketResponse( BigDecimal price, String qrCode) {

    public static TicketResponse toResponse(Ticket ticket) {
        return new TicketResponse(ticket.getPrice(), ticket.getQrCode());
    }
}
