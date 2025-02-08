package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.model.theater.Theater;
import com.github.thomazllr.moovium.model.theater.TheaterRequest;
import com.github.thomazllr.moovium.repository.TheaterRepository;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {

    private TheaterRepository repository;

    public TheaterService(TheaterRepository repository) {
        this.repository = repository;
    }

    public Theater create(TheaterRequest request) {
        return repository.save(request.toTheater());
    }
}
