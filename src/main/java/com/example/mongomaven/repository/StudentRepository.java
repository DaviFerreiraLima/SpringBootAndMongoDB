package com.example.mongomaven.repository;

import com.example.mongomaven.entities.Student;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {
    List<Student>findByName(String name);
    Student findByNameAndEmail(String name, String email);

    List<Student> findByNameOrEmail(String name, String email);

   // List<Student> findByDepartment_DepartmentName(String departName);

    List<Student> findByEmailIsLike (String email);

    List<Student> findByNameStartsWith(String name);

    List<Student> findByDepartmentId(String id);

    @Query("{ \"name\" : \"?0\" }")
    List<Student> getByName(String name);
}
