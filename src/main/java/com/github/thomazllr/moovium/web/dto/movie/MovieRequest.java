package com.github.thomazllr.moovium.web.dto.movie;

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
                           LocalDate featuredUntil
                           ) {

}