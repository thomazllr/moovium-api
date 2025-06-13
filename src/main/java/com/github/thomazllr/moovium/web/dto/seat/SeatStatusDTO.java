package com.github.thomazllr.moovium.web.dto.seat;

import com.github.thomazllr.moovium.entity.Status;
import com.github.thomazllr.moovium.repository.projections.SeatStatusProjection;

public record SeatStatusDTO(String seatNumber, String row, Status status) {

  public static SeatStatusDTO toDTO(SeatStatusProjection projection) {
      return new SeatStatusDTO(projection.getSeatNumber(), projection.getRow(), projection.getStatus());
  }

}
