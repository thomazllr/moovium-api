package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.Theater;
import com.github.thomazllr.moovium.entity.dto.theater.TheaterRequest;
import com.github.thomazllr.moovium.repository.SeatRepository;
import com.github.thomazllr.moovium.repository.TheaterRepository;
import com.github.thomazllr.moovium.validator.TheaterValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class TheaterService {

    final private TheaterRepository repository;
    final private SeatRepository seatRepository;
    final private TheaterValidator validator;

    @Transactional
    public Theater create(TheaterRequest request) {
        validator.validate(request.toTheater());
        var theater = repository.save(request.toTheater());

        List<Seat> seats = IntStream.rangeClosed('A', 'J')
                .mapToObj(row -> IntStream.rangeClosed(1, 10)
                                .mapToObj(number -> new Seat(theater, String.valueOf(number), String.valueOf((char) row)))
                                .toList())
                .flatMap(List::stream)
                .toList();

        seatRepository.saveAll(seats);

        return theater;
    }

    public List<Theater> findAll() {
        return repository.findAll();
    }
}
