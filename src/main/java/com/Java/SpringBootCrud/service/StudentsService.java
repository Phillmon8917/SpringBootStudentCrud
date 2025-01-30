package com.Java.SpringBootCrud.service;

import com.Java.SpringBootCrud.model.Student;
import com.Java.SpringBootCrud.repository.StudentsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;

    public List<Student> getStudents() {
        return studentsRepository.findAll();
    }

    String message;
    public String addNewStudent(Student student){
        Optional<Student> studentOptional = studentsRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }

        studentsRepository.save(student);

        message = "Student registered successfully!";
        return message;
    }

    public String deleteStudent(long id){

        boolean isStudentExists = studentsRepository.existsById(id);

        if(!isStudentExists){
            //Thats if you dont wanna throw an exception but instead return message
            throw new IllegalStateException("Student with id " + id + " does not exist");
        }

        studentsRepository.deleteById(id);

        message = "Student with id " + id + " has been deleted successfully!";
        return message;
    }

    @Transactional
    public String updateStudent(long id, String name, String email){
        Student student = studentsRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Student with id " + id + " does not exist!"));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentsRepository.findStudentByEmail(email);

            if (studentOptional.isPresent()){
                throw new IllegalStateException("Email is taken");
            }

            student.setEmail(email);
        }

        message = "Sudent with id " + id + ", name " + student.getName() +
                " and email " + student.getEmail() + " has been updated successfully";

        return message;
    }
}
