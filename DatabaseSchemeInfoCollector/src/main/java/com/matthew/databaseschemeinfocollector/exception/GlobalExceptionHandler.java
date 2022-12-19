package com.matthew.databaseschemeinfocollector.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public CustomException catchException(HttpStatus httpStatus, CustomExceptionMessage customExceptionMessage) {
        return new CustomException(httpStatus, customExceptionMessage);
    }

}
