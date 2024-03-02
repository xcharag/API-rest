package com.springboot.restapi.controller;

import com.springboot.restapi.beans.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class studentController {

    @GetMapping("student-info")
    public Student getStudent(){
        return new Student(
                1,
                "Oscar",
                "Aguilar"
        );
    }

    @GetMapping("students-post-get")
    public List<Student> getpostStudent(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(2,"Jorge","Urioste"));
        students.add(new Student(3,"Jorge","Urioste"));
        students.add(new Student(4,"Jorge","Urioste"));

        return students;
    }

    @GetMapping("students/{id}&&{firstName}&&{lastName}")
    public Student student(@PathVariable int id,@PathVariable String firstName,@PathVariable String lastName){
        return new Student(id,firstName,lastName);
    }
}
