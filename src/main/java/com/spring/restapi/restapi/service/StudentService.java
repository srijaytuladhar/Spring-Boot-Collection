package com.spring.restapi.restapi.service;

import com.spring.restapi.restapi.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = Arrays.asList(
            new Student("1", "Ramesh Shrestha", 21, "rameshshrestha@abcd.com"),
            new Student("2", "Tom Gurung", 22, "tommygurung@abcd.com"),
            new Student("3", "Selina Rai", 23, "selinarai@abcd.com"),
            new Student("4", "Prakash Bhattarai", 21, "prakashbhattarai@abcd.com")
    );

    public List<Student> getStudents() {
        return students;
    }
}
