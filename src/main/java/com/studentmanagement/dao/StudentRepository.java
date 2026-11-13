package com.studentmanagement.dao;

import com.studentmanagement.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    // save or create
    public void save(Student student){
        entityManager.persist(student);
    }

    // retrieve by id
    public Optional<Student> getById(Long id){
        return Optional.ofNullable(
                entityManager.find(Student.class, id)
        );
    }

    // retrieve all
    public List<Student> getAll(){
        return entityManager.createQuery(
                "SELECT s from Student s", Student.class
        ).getResultList();
    }

    //update student
    public void update(Student student){
       entityManager.merge(student);
    }

    // delete
    public void delete(Long id){
        Student student = entityManager.find(Student.class, id);
        if (student != null)
            entityManager.remove(student);
    }

}
