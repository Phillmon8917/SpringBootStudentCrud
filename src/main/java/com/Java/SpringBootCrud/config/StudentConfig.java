package com.Java.SpringBootCrud.config;

import com.Java.SpringBootCrud.model.Student;
import com.Java.SpringBootCrud.repository.StudentsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
public class StudentConfig {

    private static final Logger LOGGER = Logger.getLogger(StudentConfig.class.getName());

    @Bean
    CommandLineRunner commandLineRunner(StudentsRepository studentsRepository) {
        return args -> {
            try {
                System.out.println("Attempting to save students to the database...");

                Student phill = new Student(
                        "Phill",
                        "Motsinoni.p952@gmail.com",
                        LocalDate.of(2000, Month.FEBRUARY, 28)
                );

                Student peter = new Student(
                        "Peter",
                        "peter@gmail.com",
                        LocalDate.of(2002, Month.DECEMBER, 25)
                );

                studentsRepository.saveAll(List.of(phill, peter));

                System.out.println("Students saved successfully!");

            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, "Database connection failed", ex);
                System.out.println("Error: " + ex.getMessage()); // Keep actual error in logs
            }
        };
    }
}
