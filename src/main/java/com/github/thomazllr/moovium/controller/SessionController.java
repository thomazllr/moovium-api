package com.github.thomazllr.moovium.controller;

import com.github.thomazllr.moovium.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {

    private SessionService service;

    @Autowired
    public SessionController(SessionService service) {
        this.service = service;
    }


}
