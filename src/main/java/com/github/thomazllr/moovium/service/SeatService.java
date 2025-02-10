package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.dto.seat.SeatResponse;
import com.github.thomazllr.moovium.exceptions.TheaterNotFoundException;
import com.github.thomazllr.moovium.entity.dto.seat.SeatRequest;
import com.github.thomazllr.moovium.repository.SeatRepository;
import com.github.thomazllr.moovium.repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SeatService {

    private SeatRepository repository;
    private TheaterRepository theaterRepository;

    public SeatService(SeatRepository repository, TheaterRepository theaterRepository) {
        this.repository = repository;
        this.theaterRepository = theaterRepository;
    }

    public Seat create(SeatRequest request) {
        var theater = theaterRepository
                .findById(UUID.fromString(request.theater()))
                .orElseThrow(() -> new TheaterNotFoundException("Theater not found"));

        return repository.save(request.toSeat(theater));
    }

    public List<Seat> findAll() {
        return repository.findAll();
    }
}
