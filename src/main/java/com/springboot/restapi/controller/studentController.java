package com.springboot.restapi.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.restapi.beans.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class studentController {

    @GetMapping()
    public Student getStudent(){
        return new Student(
                1,
                "Oscar",
                "Aguilar"
        );
    }

    @GetMapping("postget")
    public List<Student> getpostStudent(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(2,"Jorge","Urioste"));
        students.add(new Student(3,"Jorge","Urioste"));
        students.add(new Student(4,"Jorge","Urioste"));

        return students;
    }

    @GetMapping("{id}&&{firstName}&&{lastName}")
    public Student student(@PathVariable int id,@PathVariable String firstName,@PathVariable String lastName){
        return new Student(id,firstName,lastName);
    }

    //http:/localhost:8080/students/query?id=1&&firstName&&lastName
    @GetMapping("query")
    public Student studentVariables(@RequestParam int id,@RequestParam String firstname, @RequestParam String lastname){
        return new Student(id,firstname,lastname);
    }

    @PostMapping("crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Student crearStudent(@RequestBody Student student){
        System.out.println(student.getId());
        return student;
    }

    @PutMapping("{id}/actualizar")
    public Student editStudent(@RequestBody Student student,@PathVariable("id") int studentID){
        return student;
    }

    @PutMapping("actualizar")
    public Student editStudent2(@RequestBody Student student){
        if (student.getId()==1){
            System.out.println(student.getFirstName());
            return student;
        }
        return null;
    }

    @DeleteMapping("{id}/borrar")
    public Student deleteStudent(@RequestBody Student student,@PathVariable("id") int studentID){
        System.out.println(studentID);
        System.out.println("Borrado con exito");
        return student;
    }
}
