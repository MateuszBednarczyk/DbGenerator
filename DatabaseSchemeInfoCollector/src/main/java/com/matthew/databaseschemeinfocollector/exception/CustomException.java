package com.matthew.databaseschemeinfocollector.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class CustomException extends IllegalArgumentException {

    @Getter
    private HttpStatus httpStatus;
    private CustomExceptionMessage message;

    @Override
    public String getMessage() {
        return message.toString();
    }
}
