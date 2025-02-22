package com.github.thomazllr.moovium.entity.dto.movie;

import com.github.thomazllr.moovium.entity.Genre;
import com.github.thomazllr.moovium.entity.Movie;

import java.time.LocalDate;

public record MovieRequest(String title,
                           String synopsis,
                           Integer duration,
                           LocalDate releaseDate,
                           Genre genre,
                           String ageRating,
                           String posterUrl,
                           Boolean isFeatured,
                           LocalDate featuredUntil,
                           String status) {

    public Movie toMovie() {
        return Movie.builder()
                .title(title)
                .synopsis(synopsis)
                .duration(duration)
                .releaseDate(releaseDate)
                .genre(genre)
                .ageRating(ageRating)
                .posterUrl(posterUrl)
                .isFeatured(isFeatured)
                .featuredUntil(featuredUntil)
                .status(status)
                .build();
    }

}
