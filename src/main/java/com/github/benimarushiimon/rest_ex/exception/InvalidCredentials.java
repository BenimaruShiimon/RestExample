package com.github.benimarushiimon.rest_ex.exception;

public class InvalidCredentials extends RuntimeException{
    public InvalidCredentials(String message) {
        super(message);
    }
}
