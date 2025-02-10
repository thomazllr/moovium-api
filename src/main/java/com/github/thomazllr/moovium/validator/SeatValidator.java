package com.github.thomazllr.moovium.validator;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.repository.SeatRepository;
import org.springframework.stereotype.Component;

@Component
public class SeatValidator {

    private SeatRepository seatRepository;

    public SeatValidator(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public void validateSeat(Seat seat) {
        if (exists(seat)) {
            throw new RuntimeException("Seat already register in this theater");
        }
    }



    boolean exists(Seat seat) {
        return seatRepository.existsByTheaterAndSeatNumberAndRow(seat.getTheater(), seat.getSeatNumber(), seat.getRow());

    }
}
