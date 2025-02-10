package com.github.thomazllr.moovium.model.movie;

import com.github.thomazllr.moovium.entity.Movie;
import com.github.thomazllr.moovium.entity.Genre;

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
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setSynopsis(synopsis);
        movie.setDuration(duration);
        movie.setReleaseDate(releaseDate);
        movie.setGenre(genre);
        movie.setAgeRating(ageRating);
        movie.setPosterUrl(posterUrl);
        movie.setFeatured(isFeatured);
        movie.setFeaturedUntil(featuredUntil);
        movie.setStatus(status);
        return movie;
    }



    }
