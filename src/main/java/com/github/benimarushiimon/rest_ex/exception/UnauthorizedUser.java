package com.github.benimarushiimon.rest_ex.exception;

public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String message) {
        super(message);
    }
}
