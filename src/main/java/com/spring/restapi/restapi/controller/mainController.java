package com.spring.restapi.restapi.controller;

import com.spring.restapi.restapi.Student;
import com.spring.restapi.restapi.service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class mainController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = "/")
    public String home() {
        return "home.jsp";
    }


    @RequestMapping("/addStudent")
    public String addStudent(Student student) {
        studentRepository.save(student);
        return "success.jsp";
    }

    @RequestMapping("/getStudent")
    public ModelAndView getStudent(String id) {
        ModelAndView modelAndView = new ModelAndView("home.jsp");
        Student student = studentRepository.findById(id).orElse(new Student());
        modelAndView.addObject(student);
        return modelAndView;
    }




}
