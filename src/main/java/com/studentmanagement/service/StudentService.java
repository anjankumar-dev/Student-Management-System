package com.studentmanagement.service;

import com.studentmanagement.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    void register(Student student);
    List<Student> displayAll();
    Optional<Student> getStudentById(Long id);
    void updateStudent(Student student);
    void deleteStudent(Long id);
}
