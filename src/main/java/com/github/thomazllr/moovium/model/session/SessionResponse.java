//package com.github.thomazllr.moovium.model.session;
//
//
//import com.github.thomazllr.moovium.model.ticket.TicketResponse;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//public record SessionResponse(UUID id, LocalDateTime sessionTime, Integer seatsAvailable, Integer totalSeats, List<TicketResponse> tickets) {
//    public static SessionResponse toResponse(Session session) {
//        if (session.getTickets() == null) {
//            session.setTickets(new ArrayList<>());
//        }
//        return new SessionResponse(
//                session.getId(),
//                session.getSessionTime(),
//                session.getSeatsAvailable(),
//                session.getTotalSeats(),
//                session.getTickets().stream().map(TicketResponse::toResponse).toList());
//    }
//}
