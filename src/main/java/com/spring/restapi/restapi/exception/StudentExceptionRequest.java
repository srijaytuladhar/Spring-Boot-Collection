package com.spring.restapi.restapi.exception;

public class StudentExceptionRequest extends RuntimeException{

    public StudentExceptionRequest(String message) {
        super(message);
    }
}
