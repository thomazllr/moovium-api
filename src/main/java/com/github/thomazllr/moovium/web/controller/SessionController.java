package com.github.thomazllr.moovium.web.controller;
import com.github.thomazllr.moovium.web.mapper.SessionMapper;
import com.github.thomazllr.moovium.web.dto.session.SessionRequest;
import com.github.thomazllr.moovium.web.dto.session.SessionResponse;
import com.github.thomazllr.moovium.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

import static com.github.thomazllr.moovium.util.UriUtil.generateHeaderLocation;

@RequiredArgsConstructor
@RestController
@RequestMapping("/session")
public class SessionController {

    private final SessionService service;

    @PostMapping
    public ResponseEntity<SessionResponse> getSession(@RequestBody SessionRequest request) {
        var session = service.create(SessionMapper.fromRequest(request));
        URI location = generateHeaderLocation(session.getId());
        return ResponseEntity.created(location).body(SessionMapper.toResponse(session));
    }

    @GetMapping
    public ResponseEntity<List<SessionResponse>> getAllSessions() {
        return ResponseEntity.ok(service.findAll().stream().map(SessionMapper::toResponse).toList());
    }



}
