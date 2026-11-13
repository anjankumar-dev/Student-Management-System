package com.studentmanagement.service;

import com.studentmanagement.dao.StudentRepository;
import com.studentmanagement.exception.StudentNotFoundException;
import com.studentmanagement.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepo;

    public StudentServiceImpl(StudentRepository studentRepo){
        this.studentRepo = studentRepo;
    }

    @Override
    public void register(Student student) {
        studentRepo.save(student);
    }

    @Override
    public List<Student> displayAll() {
        return studentRepo.getAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return Optional.of(
                studentRepo.getById(id)
                        .orElseThrow(() ->
                                new StudentNotFoundException("No student found with ID: " + id))
        );
    }

    @Override
    public void updateStudent(Student student) {
        studentRepo.update(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.delete(id);
    }
}
