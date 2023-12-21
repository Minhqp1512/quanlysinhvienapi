package com.example.demo.api.controller;
import com.example.demo.api.exeption.ResourceNotFoundException;
import com.example.demo.api.model.Student;
import com.example.demo.api.repository.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
//them moi 1 dong

    @GetMapping("quanlysinhvien")
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }
    @GetMapping("quanlysinhvien/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value ="id") Long studenrID )
    throws ResourceNotFoundException
    {
                Student student= studentRepository.findById(studenrID)
                        .orElseThrow(() -> new ResourceNotFoundException("khong co sinh vien nhu lay"+ studenrID));
                return ResponseEntity.ok().body(student);
    }
    @PostMapping("quanlysinhvien")
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentRepository.save(student);
    }
    @PutMapping("quanlysinhvien/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
                                                 @Valid @RequestBody Student studentDetails)
            throws ResourceNotFoundException{
        Student student= studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("khong co sinh vien nhu lay" +studentId));

        student.setName(studentDetails.getName());
        student.setBirthday(studentDetails.getBirthday());
        student.setSex(studentDetails.getSex());
        student.setAddress(studentDetails.getAddress());
        student.setMath(studentDetails.getMath());
        student.setEnglish(studentDetails.getEnglish());
        student.setLiterature(studentDetails.getLiterature());

        final Student updateStudent = studentRepository.save(student);
        return ResponseEntity.ok(updateStudent);

    }
    @DeleteMapping("quanlysinhvien/{id}")
    public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long studentId)
        throws ResourceNotFoundException{
        Student student =studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("khong co sinh vien nhu lay"+ studentId));

                studentRepository.delete(student);
                Map<String, Boolean> response = new HashMap<>();
                response.put("delete", Boolean.TRUE);
                return response;

    }




}
