package com.Java.SpringBootCrud.controller;

import com.Java.SpringBootCrud.model.Student;
import com.Java.SpringBootCrud.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentsService.getStudents();
    }

    @PostMapping("create")
    public String registerNewStudent(@RequestBody Student student){
        return studentsService.addNewStudent(student);
    }

    @DeleteMapping("delete/{id}")
    public String deleteStudent(@PathVariable long id){
        return studentsService.deleteStudent(id);
    }

    @PutMapping("update/{id}")
    public String updateStudent(@PathVariable long id, @RequestParam(required = false) String name,
                                @RequestParam(required = false) String email){
        return studentsService.updateStudent(id, name, email);
    }
}
