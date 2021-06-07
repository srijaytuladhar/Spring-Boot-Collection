package com.spring.restapi.restapi.controller;

import com.spring.restapi.restapi.Student;
import com.spring.restapi.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/students")
    public ResponseEntity<Object> getStudent() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    /*public List<Student> getStudent() {
        return studentService.getStudents();
    }*/
}
