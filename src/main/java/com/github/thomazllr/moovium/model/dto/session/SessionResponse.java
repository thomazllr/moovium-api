package com.github.thomazllr.moovium.model.dto.session;

import com.github.thomazllr.moovium.model.Session;

import java.time.LocalDateTime;
import java.util.UUID;

public record SessionResponse(UUID id, LocalDateTime sessionTime, Integer seatsAvailable, Integer totalSeats,
                              String theaterName) {
    public SessionResponse(Session session) {
        this(session.getId(), session.getSessionTime(), session.getSeatsAvailable(), session.getTotalSeats(), session.getTheaterName());
    }
}
