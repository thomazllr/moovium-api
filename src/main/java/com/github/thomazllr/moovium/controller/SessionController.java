package com.github.thomazllr.moovium.controller;

import com.github.thomazllr.moovium.mapper.SessionMapper;
import com.github.thomazllr.moovium.entity.dto.session.SessionRequest;
import com.github.thomazllr.moovium.entity.dto.session.SessionResponse;
import com.github.thomazllr.moovium.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import static com.github.thomazllr.moovium.util.UriUtil.generateHeaderLocation;

@RestController
@RequestMapping("/session")
public class SessionController {

    private SessionService service;

    @Autowired
    public SessionController(SessionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SessionResponse> getSession(@RequestBody SessionRequest request, Locale locale) {
        var session = service.create(request);
        URI location = generateHeaderLocation(session.getId());
        return ResponseEntity.created(location).body(SessionMapper.toResponse(session));
    }

    @GetMapping
    public ResponseEntity<List<SessionResponse>> getAllSessions() {
        return ResponseEntity.ok(service.findAll().stream().map(SessionMapper::toResponse).toList());
    }



}
