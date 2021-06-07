package com.spring.restapi.restapi.controller;

import com.spring.restapi.restapi.Student;
import com.spring.restapi.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public List<Student> getStudent() {
        return studentService.getStudents();
    }
}
