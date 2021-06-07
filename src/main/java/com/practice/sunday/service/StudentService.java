package com.practice.sunday.service;

import com.practice.sunday.Student;
import com.practice.sunday.exception.StudentExceptionRequest;
import com.practice.sunday.exception.StudentNotFoundException;
import com.practice.sunday.response.StudentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService implements StudentInterface{

    private Logger logger = LoggerFactory.getLogger(StudentService.class);

    private List<Student> students = new ArrayList<>(Arrays.asList(
            new Student("1", "John Cena", 22, "john@spring.com"),
            new Student("2", "Tom Cruise", 23, "tom@spring.com")
    ));

    @Override
    public List<Student> getStudents() {
        logger.info("Accessing Student details....");
        return students;
    }

    @Override
    public Student getStudentById(String id) {
        if (students.stream().filter(c->c.getId().equals(id)).findFirst().isPresent()) {
            return students.stream().filter(s->s.getId().equals(id)).findFirst().get();
        }
        else {
            logger.warn("Student with id: " + id + " not present!!");
            throw new StudentExceptionRequest("Student not found");
        }
    }

    @Override
    public void updateStudent(String id, Student student) {
        for (int i=0; i<students.size(); i++) {
            Student s = students.get(i);
            if (s.getId().equals(id)) {
                students.set(i, student);
            }
        }
        System.out.println("Student with id: " +id+ " updated successfully!!");
    }

    @Override
    public void createStudent(Student student) {
        students.add(student);
        System.out.println("Student created successfully!!");
    }

    @Override
    public void deleteStudent(String id) {
        if (students.stream().filter(c->c.getId().equals(id)).findFirst().isPresent()) {
            students.removeIf(s->s.getId().equals(id));
            System.out.println("Student with id: " +id+ " deleted successfully!!");
        }
        else {
            logger.warn("Student with id: " + id + " not present!!");
            throw new StudentExceptionRequest("Cannot delete.... Student not found");
        }
    }


}
