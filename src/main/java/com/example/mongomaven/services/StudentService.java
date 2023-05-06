package com.example.mongomaven.services;

import com.example.mongomaven.entities.Student;
import com.example.mongomaven.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }
    public Student getStudentById(String id){
        return studentRepository.findById(id).get();
    }
    public List<Student> getAllStudents(){
        return  studentRepository.findAll();
    }

    public Student updateStudent(Student student){
           return studentRepository.save(student);
    }

    public String deleteStudent( String id){
         studentRepository.deleteById(id);
         return "The student has benn deleted from the system";
    }

    public List<Student> getStudentByName(String name){
        return studentRepository.findByName(name);
    }

    public Student getStudentByNameAndMail(String name, String email){
        return  studentRepository.findByNameAndEmail(name,email);
    }
    public List<Student> getStudentsByNameOrderByEmail(String name, String email){
        return  studentRepository.findByNameOrEmail(name,email);
    }
}

