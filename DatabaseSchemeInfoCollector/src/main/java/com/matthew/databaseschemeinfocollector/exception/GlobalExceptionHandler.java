package com.matthew.databaseschemeinfocollector.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public CustomException catchCustomException(HttpStatus httpStatus, CustomExceptionMessage customExceptionMessage) {
        return new CustomException(httpStatus, customExceptionMessage);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String catchPlainException(RuntimeException exception){
        return exception.getMessage();
    }

}
