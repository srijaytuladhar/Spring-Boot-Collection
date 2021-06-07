package com.practice.sunday.service;

import com.practice.sunday.Student;

import java.util.List;

public interface StudentInterface {
    public abstract List<Student> getStudents ();
    public abstract Student getStudentById(String id);
    public abstract void updateStudent(String id, Student student);
    public abstract void createStudent(Student student);
    public abstract void deleteStudent(String id);
}
