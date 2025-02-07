package com.github.thomazllr.moovium.exceptions;

public class MovieNotFoundException extends RuntimeException{

    public MovieNotFoundException(String message) {
        super(message);
    }

    public MovieNotFoundException() {
    }
}
