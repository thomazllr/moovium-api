package com.github.thomazllr.moovium.validator;

import com.github.thomazllr.moovium.entity.Theater;
import com.github.thomazllr.moovium.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TheaterValidator {

    @Autowired
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
