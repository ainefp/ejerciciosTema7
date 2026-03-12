package com.example.ejercicio601.exception;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse handleRuntimeException(RuntimeException ex) {
        return new ErrorResponse(ex.getMessage(), LocalDateTime.now(), ex.getClass().getSimpleName());
    }
    // +ExceptionHandler
}
