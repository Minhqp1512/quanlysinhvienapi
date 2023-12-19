package com.example.demo.api.controller;
import com.example.demo.api.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @GetMapping("/student")
    public Student getStudent(@RequestParam Integer id){
        Optional<Student> student= studentService.getStudent(id);
        return (Student) student.orElse(null);
    }

}
