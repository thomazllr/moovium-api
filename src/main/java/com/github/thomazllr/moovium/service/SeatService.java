package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.Session;
import com.github.thomazllr.moovium.entity.dto.seat.SeatResponse;
import com.github.thomazllr.moovium.exceptions.TheaterNotFoundException;
import com.github.thomazllr.moovium.entity.dto.seat.SeatRequest;
import com.github.thomazllr.moovium.repository.SeatRepository;
import com.github.thomazllr.moovium.repository.SeatReservationRepository;
import com.github.thomazllr.moovium.repository.SessionRepository;
import com.github.thomazllr.moovium.repository.TheaterRepository;
import com.github.thomazllr.moovium.validator.SeatValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SeatService {

    private final SessionRepository sessionRepository;
    private SeatRepository repository;
    private TheaterRepository theaterRepository;
    private SeatReservationRepository seatReservationRepository;
    private SeatValidator validator;

    public SeatService(SeatRepository repository, TheaterRepository theaterRepository, SeatReservationRepository seatReservationRepository, SeatValidator validator, SessionRepository sessionRepository) {
        this.repository = repository;
        this.theaterRepository = theaterRepository;
        this.seatReservationRepository = seatReservationRepository;
        this.validator = validator;
        this.sessionRepository = sessionRepository;
    }

    public Seat create(SeatRequest request) {
        var theater = theaterRepository
                .findById(UUID.fromString(request.theater()))
                .orElseThrow(() -> new TheaterNotFoundException("Theater not found"));
        var seat = request.toSeat(theater);
        validator.validateSeat(seat);
        return repository.save(seat);
    }


    public List<Seat> findAll() {
        return repository.findAll();
    }

    public List<Seat> getSeatsForSession(String id) {
        var session = sessionRepository.findById(UUID.fromString(id)).orElseThrow(() -> new RuntimeException("Session not found!"));
        return repository.findByTheater(session.getTheater());

    }
}
