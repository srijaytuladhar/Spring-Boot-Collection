package com.practice.sunday.exception;

public class StudentExceptionRequest extends RuntimeException{

    public StudentExceptionRequest(String message) {
        super(message);
    }
}
