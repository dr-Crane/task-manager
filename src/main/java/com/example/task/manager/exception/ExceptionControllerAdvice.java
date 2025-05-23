package com.example.task.manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(exception = InvalidTitleException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionModel handleInvalidTitleException(
            InvalidTitleException exception
    ) {
        return ExceptionModel.builder()
                .message(exception.getMessage())
                .timestamp(Instant.now())
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

}
