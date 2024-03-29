package com.example.refactorCRUDbp.Student.infraestructure.repository;

import com.example.refactorCRUDbp.Student.domain.Student;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    Student getStudentByIdStudent( String idStudent);


}
