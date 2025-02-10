package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.dto.seat.SeatResponse;
import com.github.thomazllr.moovium.exceptions.TheaterNotFoundException;
import com.github.thomazllr.moovium.entity.dto.seat.SeatRequest;
import com.github.thomazllr.moovium.repository.SeatRepository;
import com.github.thomazllr.moovium.repository.TheaterRepository;
import com.github.thomazllr.moovium.validator.SeatValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SeatService {

    private SeatRepository repository;
    private TheaterRepository theaterRepository;
    private SeatValidator validator;

    public SeatService(SeatRepository repository, TheaterRepository theaterRepository, SeatValidator validator) {

        this.repository = repository;
        this.theaterRepository = theaterRepository;
        this.validator = validator;
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
}
