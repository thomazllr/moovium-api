package com.github.thomazllr.moovium.validator;

import com.github.thomazllr.moovium.entity.Theater;
import com.github.thomazllr.moovium.repository.TheaterRepository;
import org.springframework.stereotype.Component;

@Component
public class TheaterValidator {

    private TheaterRepository theaterRepository;

    public void validate(Theater theater) {
        if(existsTheaterWithThatName(theater)) {
            throw new RuntimeException("There is already an existing theater with that name");
        }
    }

    boolean existsTheaterWithThatName(Theater theater) {
        return theaterRepository.existsByName(theater.getName());
    }
}
