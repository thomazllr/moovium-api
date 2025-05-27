package com.github.thomazllr.moovium.web.mapper;

import com.github.thomazllr.moovium.entity.Theater;
import com.github.thomazllr.moovium.web.dto.theater.TheaterRequest;
import com.github.thomazllr.moovium.web.dto.theater.TheaterResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TheaterMapper {

    Theater toEntity(TheaterRequest request);

    TheaterResponse toResponse(Theater theater);

}
