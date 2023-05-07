package com.example.mongomaven.controller;

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

        @GetMapping("/studentByNameAndMail")
        public Student studentByNameAndMail(@RequestParam String name, @RequestParam String email){
            return studentService.getStudentByNameAndMail(name,email);
        }

        @GetMapping("/studentsByNameOrMail")
        public List<Student> studentsByNameOrderByEmail(String name, String email){
            return  studentService.getStudentsByNameOrderByEmail(name,email);
        }

        @GetMapping("/allWithPagination")
        public List<Student> getAllWithPagination(@RequestParam int pageNumber,@RequestParam int pageSize){
            return studentService.getAllWithPagination(pageNumber,pageSize);
        }

    @GetMapping("/allWithSorting")
    public List<Student> AllWithSorting(){
        return studentService.AllWithSorting();
    }

    /*@GetMapping("/byDepartamentName")
    public List<Student> ByDepartamentName(@RequestParam String departName){
        return studentService.getByDepartamentName(departName);
    }*/

    @GetMapping("/byEmail")
    public List<Student> ByEmail(@RequestParam String email){
        return studentService.getByEmail(email);
    }

    @GetMapping("/nameStartsWith")

    public List<Student> getNameStartsWith(@RequestParam String name){
        return studentService.getNameStartsWith(name);
    }
    @GetMapping("/byDepartmentId")
    public List<Student> getByDepartmentId(@RequestParam String id){
        return studentService.getDepartmentById(id);
    }


}
