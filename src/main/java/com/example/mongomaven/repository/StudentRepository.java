package com.example.mongomaven.repository;

import com.example.mongomaven.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
    List<Student>findByName(String name);
    Student findByNameAndEmail(String name, String email);

    List<Student> findByNameOrEmail(String name, String email);
}
