package com.example.demo.service;

import com.example.demo.api.model.Student;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

@Service
public class StudentService {
    private List<Student> studentList;

    public StudentService() {
        studentList = new ArrayList<>();

        Student student1 = new Student(1, "Minh", "12/12/2002", "Nam", "Ninh binh", 7, 9, 8);
        Student student2 = new Student(2, "Linh", "1/8/1986", "Nu", "Ha noi", 9, 9, 8);
        Student student3 = new Student(3, "Tien", "3/9/2000", "Nam", "Bac Lieu", 7, 6, 3);
        Student student4 = new Student(4, "Tho", "20/6/2009", "Nam", "Hoa Binh", 5, 9, 7);
        Student student5 = new Student(5, "Loc", "19/5/1996", "Nam", "Soc Trang", 7, 7, 8);

        studentList.addAll(Arrays.asList(student1, student2, student3, student4, student5));
    }

    public Optional<Student> getStudent(Integer id) {
        Optional<Student> optional = Optional.empty();
        for (Student user : studentList) {
            if (id == user.getId()) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}
