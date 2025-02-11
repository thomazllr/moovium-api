package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.SeatReservation;
import com.github.thomazllr.moovium.repository.SeatRepository;
import com.github.thomazllr.moovium.repository.SeatReservationRepository;
import com.github.thomazllr.moovium.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SessionSeatService {

    private SeatRepository seatRepository;
    private SessionRepository sessionRepository;
    private SeatReservationRepository seatReservationRepository;

    public SessionSeatService(SeatRepository seatRepository, SessionRepository sessionRepository, SeatReservationRepository seatReservationRepository) {
        this.seatRepository = seatRepository;
        this.sessionRepository = sessionRepository;
        this.seatReservationRepository = seatReservationRepository;
    }

    public List<Seat> getSeatsStatusForSession(String sessionId) {
        return null;
    }

    public List<Seat> getSeatsForSession(String sessionId) {
        var session = sessionRepository.findById(UUID.fromString(sessionId)).orElseThrow(() -> new RuntimeException("Session not found!"));
        return seatRepository.findByTheater(session.getTheater());
    }

    public List<SeatReservation> getsSeatsReservationForSession(String sessionId) {
        var session = sessionRepository.findById(UUID.fromString(sessionId)).orElseThrow(() -> new RuntimeException("Session not found!"));
        return seatReservationRepository.findBySession(session);
    }
}
