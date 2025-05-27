package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.SeatReservation;
import com.github.thomazllr.moovium.repository.SeatRepository;
import com.github.thomazllr.moovium.repository.SeatReservationRepository;
import com.github.thomazllr.moovium.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SessionSeatService {

    private final SeatRepository seatRepository;
    private final SessionRepository sessionRepository;
    private final SeatReservationRepository seatReservationRepository;

    public List<Seat> getSeatsForSession(String sessionId) {
        var session = sessionRepository.findById(UUID.fromString(sessionId)).orElseThrow(() -> new RuntimeException("Session not found!"));
        return seatRepository.findByTheater(session.getTheater());
    }

    public List<SeatReservation> getsSeatsReservationForSession(String sessionId) {
        var session = sessionRepository.findById(UUID.fromString(sessionId)).orElseThrow(() -> new RuntimeException("Session not found!"));
        return seatReservationRepository.findBySession(session);
    }
}
