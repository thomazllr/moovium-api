package com.github.thomazllr.moovium.controller;

import com.github.thomazllr.moovium.model.Session;
import com.github.thomazllr.moovium.model.dto.session.SessionRequest;
import com.github.thomazllr.moovium.model.dto.session.SessionResponse;
import com.github.thomazllr.moovium.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {

    private SessionService service;

    @Autowired
    public SessionController(SessionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Session> save(@RequestBody SessionRequest request) {
        Session session = service.create(request);
        URI location = URI.create("/session/" + session.getId());
        return ResponseEntity.created(location).body(session);
    }

    @GetMapping
    public ResponseEntity<List<SessionResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
