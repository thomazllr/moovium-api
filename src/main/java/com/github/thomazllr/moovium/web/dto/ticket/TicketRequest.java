//package com.github.thomazllr.moovium.model.ticket;
//
//import com.github.thomazllr.moovium.entity.Session;
//
//import java.math.BigDecimal;
//
//public record TicketRequest(String session, String seatNumber, BigDecimal price) {
//
//    public Ticket toTicket(Session session) {
//        Ticket ticket = new Ticket();
//        ticket.setSeatNumber(seatNumber);
//        ticket.setPrice(price);
//        return ticket;
//    }
//}
