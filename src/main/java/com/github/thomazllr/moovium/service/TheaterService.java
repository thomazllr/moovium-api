package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.Theater;
import com.github.thomazllr.moovium.entity.dto.theater.TheaterRequest;
import com.github.thomazllr.moovium.repository.SeatRepository;
import com.github.thomazllr.moovium.repository.TheaterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class TheaterService {

    private TheaterRepository repository;
    private SeatRepository seatRepository;

    public TheaterService(TheaterRepository repository, SeatRepository seatRepository) {
        this.repository = repository;
        this.seatRepository = seatRepository;
    }

    @Transactional
    public Theater create(TheaterRequest request) {
        var theater = repository.save(request.toTheater());
        List<Seat> seats = new ArrayList<>();

        for (char row = 'A'; row <= 'J'; row++) {
            for (int number = 1; number <= 10; number++) {
                seats.add(new Seat(theater, String.valueOf(number), String.valueOf(row)));
            }
        }

        seatRepository.saveAll(seats);

        return theater;
    }
}
