package com.example.mongomaven.Controller;

import com.example.mongomaven.entities.Student;
import com.example.mongomaven.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

   @GetMapping("/getById/{id}")
      public Student getStudentById(@PathVariable String id){
        return studentService.getStudentById(id);

    }

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }


    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
       return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id){
        return  studentService.deleteStudent(id);
    }

    @GetMapping("/studentsByName/{name}")
        public List<Student> studentsByName(@PathVariable String name){
            return studentService.getStudentByName(name);
        }


}
