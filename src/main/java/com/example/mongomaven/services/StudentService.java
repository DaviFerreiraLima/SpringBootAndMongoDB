package com.example.mongomaven.services;

import com.example.mongomaven.entities.Student;
import com.example.mongomaven.repository.DepartmentRepository;
import com.example.mongomaven.repository.StudentRepository;
import com.example.mongomaven.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    SubjectRepository subjectRepository;
    public Student createStudent(Student student){
        if (student.getDepartment() != null){
            departmentRepository.save(student.getDepartment());
        }
        if(student.getSubjects()!=null && student.getSubjects().size() > 0){
            subjectRepository.saveAll(student.getSubjects());
        }
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
        return studentRepository.getByName(name);
    }

    public Student getStudentByNameAndMail(String name, String email){
        return  studentRepository.findByNameAndEmail(name,email);
    }
    public List<Student> getStudentsByNameOrderByEmail(String name, String email){
        return  studentRepository.findByNameOrEmail(name,email);
    }

    public List<Student> getAllWithPagination(int pageNumber,int pageSize){
        Pageable pageable = PageRequest.of(pageNumber-1,pageSize);
        return studentRepository.findAll(pageable).getContent();
    }


    public List<Student> AllWithSorting(){
        Sort sort = Sort.by(Sort.Direction.ASC,"name");
        return studentRepository.findAll(sort);
    }

  /*  public List<Student> getByDepartamentName(@RequestParam String departName){
        return studentRepository.findByDepartment_DepartmentName(departName);
    }*/

    public List<Student> getByEmail(@RequestParam String email){
        return studentRepository.findByEmailIsLike(email);
    }

    public List<Student> getNameStartsWith(@RequestParam String name){
        return studentRepository.findByNameStartsWith(name);
    }

    public List<Student> getDepartmentById(@RequestParam String id){
        return studentRepository.findByDepartmentId(id);
    }


}

