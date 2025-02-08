package com.github.thomazllr.moovium.model.ticket;

import java.math.BigDecimal;

public record TicketResponse(String seatNumber, BigDecimal price, boolean isSold, String qrCode) {

    public static TicketResponse toResponse(Ticket ticket) {
        return new TicketResponse(ticket.getSeatNumber(), ticket.getPrice(), ticket.isSold(), ticket.getQrCode());
    }
}
