package com.practice.sunday.response;

import com.practice.sunday.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.util.List;

public class StudentResponse {



    private List<Student> students;
    private String customMessage;
    private HttpStatus httpStatus;

    public StudentResponse(List<Student> students, String customMessage, HttpStatus httpStatus) {
        this.students = students;
        this.customMessage = customMessage;
        this.httpStatus = httpStatus;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getCustomMessage() {
        return customMessage;
    }

    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
