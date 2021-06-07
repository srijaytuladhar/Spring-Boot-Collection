package com.practice.sunday.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class StudentExceptionHandler {
    private HttpStatus httpStatus = HttpStatus.NOT_FOUND;
    @ExceptionHandler(value = {StudentExceptionRequest.class})
    public ResponseEntity<Object> responseEntity (StudentExceptionRequest exceptionRequest) {

        // create instance
        StudentNotFoundException studentNotFoundException = new StudentNotFoundException(
                exceptionRequest.getMessage(),
                httpStatus,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        // return response entity
        return new ResponseEntity<>(studentNotFoundException, httpStatus);
    }
}
