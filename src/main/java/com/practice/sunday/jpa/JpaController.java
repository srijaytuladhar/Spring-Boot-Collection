package com.practice.sunday.jpa;

import com.practice.sunday.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JpaController {


    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = "/jpa")
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

    /*public ResponseEntity<Object> showStudent(int id) {
        Student student = studentRepository.findById(id).orElse(new Student());
        return new ResponseEntity<>(student, HttpStatus.OK);
    }*/

}
