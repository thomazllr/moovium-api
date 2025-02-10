package com.github.thomazllr.moovium.validator;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.Theater;
import com.github.thomazllr.moovium.repository.SeatRepository;
import com.github.thomazllr.moovium.repository.TheaterRepository;
import org.springframework.stereotype.Component;

@Component
public class SeatValidator {

    private SeatRepository seatRepository;
    private TheaterRepository theaterRepository;

    public SeatValidator(SeatRepository seatRepository, TheaterRepository theaterRepository) {
        this.seatRepository = seatRepository;
        this.theaterRepository = theaterRepository;
    }

    public void validateSeat(Seat seat) {
        if (exists(seat)) {
            throw new RuntimeException("Seat already register in this theater");
        }
    }



    boolean exists(Seat seat) {
        return seatRepository.existsByTheaterAndSeatNumberAndRowNumber(seat.getTheater(), seat.getSeatNumber(), seat.getRowNumber());

    }
}
