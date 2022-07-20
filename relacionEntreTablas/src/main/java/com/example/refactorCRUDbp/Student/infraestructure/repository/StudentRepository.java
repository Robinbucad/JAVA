package com.example.refactorCRUDbp.Student.infraestructure.repository;

import com.example.refactorCRUDbp.Student.domain.Student;
import com.example.refactorCRUDbp.Student.infraestructure.controller.input.StudentInputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentOutputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentPersonaOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    StudentOutputDTO getStudentByIdStudent( String idStudent);

    StudentPersonaOutputDTO getStudentPersonaByIdStudent(String idStudent);

}
