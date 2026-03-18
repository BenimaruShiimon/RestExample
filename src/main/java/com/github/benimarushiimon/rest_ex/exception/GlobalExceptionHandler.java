package com.github.benimarushiimon.rest_ex.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ResponseStatus(BAD_REQUEST) // Код статуса 400
    @ExceptionHandler(InvalidCredentials.class)
    @ResponseBody
    public ErrorResponse handleInvalidCredentialsException(InvalidCredentials ex, HttpServletRequest request) {
        log.warn("Неверные учетные данные, предоставленные для {}: {}", request.getRemoteAddr(), ex.getMessage());
        return ErrorResponse.create(
                ex,
                BAD_REQUEST,
                ex.getMessage()
        );
    }

    @ResponseStatus(UNAUTHORIZED) // Код статуса 401
    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseBody
    public ErrorResponse handleUnauthorizedUserException(UnauthorizedUser ex, HttpServletRequest request) {
        log.error("Попытка несанкционированного доступа из {} с ошибкой: {}", request.getRemoteAddr(), ex.getMessage());
        return ErrorResponse.create(
                ex,
                UNAUTHORIZED,
                ex.getMessage()
        );
    }
}
