package com.github.thomazllr.moovium.model.dto.session;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.thomazllr.moovium.model.Movie;
import com.github.thomazllr.moovium.model.Session;
import com.github.thomazllr.moovium.model.dto.movie.MovieResponse;
import com.github.thomazllr.moovium.model.dto.ticket.TicketResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record SessionResponse(UUID id, LocalDateTime sessionTime, Integer seatsAvailable, Integer totalSeats,
                              String theaterName, List<TicketResponse> tickets) {
    public static SessionResponse toResponse(Session session) {
        if (session.getTickets() == null) {
            session.setTickets(new ArrayList<>());
        }
        return new SessionResponse(
                session.getId(),
                session.getSessionTime(),
                session.getSeatsAvailable(),
                session.getTotalSeats(),
                session.getTheaterName(),
                session.getTickets().stream().map(TicketResponse::toResponse).toList());
    }
}
