package com.github.thomazllr.moovium.web.mapper;

import com.github.thomazllr.moovium.entity.Movie;
import com.github.thomazllr.moovium.web.dto.movie.MovieRequest;
import com.github.thomazllr.moovium.web.dto.movie.MovieResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    Movie toEntity(MovieRequest request);

    MovieResponse toResponse(Movie movie);
}
