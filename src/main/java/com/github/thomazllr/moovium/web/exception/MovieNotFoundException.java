package com.github.thomazllr.moovium.web.exception;

public class MovieNotFoundException extends RuntimeException{

    public MovieNotFoundException(String message) {
        super(message);
    }

    public MovieNotFoundException() {
    }
}
