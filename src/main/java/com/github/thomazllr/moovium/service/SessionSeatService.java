package com.github.thomazllr.moovium.service;

import com.github.thomazllr.moovium.repository.SeatRepository;
import com.github.thomazllr.moovium.repository.projections.SeatStatusProjection;
import com.github.thomazllr.moovium.web.dto.seat.SeatStatusDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SessionSeatService {

    private final SeatRepository seatRepository;

    public List<SeatStatusDTO> getSeatStatusesForSession(String sessionId) {
        List<SeatStatusProjection> projections = seatRepository.findSeatStatusesBySessionId(UUID.fromString(sessionId));
        return projections.stream()
                .map(SeatStatusDTO::toResponse)
                .toList();
    }
}
