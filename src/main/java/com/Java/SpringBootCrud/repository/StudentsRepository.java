package com.Java.SpringBootCrud.repository;

import com.Java.SpringBootCrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByEmail(String email);
}
