package com.github.thomazllr.moovium.validator;

import com.github.thomazllr.moovium.entity.SeatReservation;
import com.github.thomazllr.moovium.repository.SeatReservationRepository;
import org.springframework.stereotype.Component;

@Component
public class SeatReservationValidator {

    private SeatReservationRepository repository;


    public SeatReservationValidator(SeatReservationRepository repository) {
        this.repository = repository;
    }

    public void validate(SeatReservation seatReservation) {
        if(seatAlreadyReserved(seatReservation)){
           throw new RuntimeException("Seat already SOLD");
        }
    }


    public boolean seatAlreadyReserved(SeatReservation seatReservation) {
        return repository.existsBySessionAndSeatAndStatus(seatReservation.getSession(), seatReservation.getSeat(), seatReservation.getStatus());
    }


}
