package com.github.thomazllr.moovium.web.mapper;

import com.github.thomazllr.moovium.entity.Theater;
import com.github.thomazllr.moovium.web.dto.theater.TheaterResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TheaterMapper {

    TheaterResponse toResponse(Theater theater);
}
