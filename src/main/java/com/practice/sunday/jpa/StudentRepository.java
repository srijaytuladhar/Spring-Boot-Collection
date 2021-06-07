package com.practice.sunday.jpa;

import com.practice.sunday.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String>{

}

