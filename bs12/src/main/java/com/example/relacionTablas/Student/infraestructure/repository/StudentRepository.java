package com.example.relacionTablas.Student.infraestructure.repository;

import com.example.relacionTablas.Student.domain.Student;
import com.example.relacionTablas.Student.infraestructure.controller.output.StudentOutputDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,String> {

    StudentOutputDto findStudentByIdStudent(String idStudent);

    Student findByIdStudent(String idStudent);

}
