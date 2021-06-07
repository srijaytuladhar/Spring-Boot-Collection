package com.practice.sunday.controller;

import com.practice.sunday.Student;
import com.practice.sunday.paths.PathHandler;
import com.practice.sunday.response.CrudResponse;
import com.practice.sunday.response.StudentResponse;
import com.practice.sunday.service.StudentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    private StudentResponse studentResponse;
    private CrudResponse crudResponse;

    // GET
    @Bean
    @RequestMapping(PathHandler.students_path)
    public StudentResponse displayStudents () {
        return new StudentResponse(studentService.getStudents(),
                "This is a custom message, please ignore it....",
                HttpStatus.OK);
    }

    @RequestMapping(PathHandler.students_by_id)
    public Student getStudentById (@PathVariable String id) {
        return studentService.getStudentById(id);
    }


    // POST
    @RequestMapping(value = PathHandler.students_path, method = RequestMethod.POST)
    public CrudResponse createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return new CrudResponse( "Student added successfully!!",
                HttpStatus.ACCEPTED, ZonedDateTime.now());
    }

    // PUT
    @RequestMapping(value = PathHandler.students_by_id, method = RequestMethod.PUT)
    public CrudResponse updateStudent(@RequestBody Student student, @PathVariable String id) {
        studentService.updateStudent(id, student);
        return new CrudResponse("Record having Student ID: " +id+ " updated successfully!!",
                HttpStatus.ACCEPTED, ZonedDateTime.now());
    }

    // DELETE
    @RequestMapping(value = PathHandler.students_by_id, method = RequestMethod.DELETE)
    public CrudResponse deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return new CrudResponse("Deleted Successfully",
                HttpStatus.ACCEPTED, ZonedDateTime.now());
    }
}
