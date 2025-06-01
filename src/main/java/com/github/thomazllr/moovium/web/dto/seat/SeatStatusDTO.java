package com.github.thomazllr.moovium.web.dto.seat;

import com.github.thomazllr.moovium.entity.Seat;
import com.github.thomazllr.moovium.entity.SeatReservation;
import com.github.thomazllr.moovium.entity.Status;
import com.github.thomazllr.moovium.repository.projections.SeatStatusProjection;
import lombok.Builder;

@Builder
public record SeatStatusDTO(String seatNumber, String row, Status status) {

  public static SeatStatusDTO toResponse(SeatStatusProjection projection) {
      return SeatStatusDTO.builder()
              .seatNumber(projection.getSeatNumber())
              .row(projection.getRow())
              .status(projection.getStatus())
              .build();
  }

}
