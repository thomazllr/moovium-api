package com.github.thomazllr.moovium.web.dto.movie;

import com.github.thomazllr.moovium.entity.Genre;
import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;

public record MovieResponse(UUID id, String title, Genre genre, LocalDate releaseDate, Integer duration) {
}
