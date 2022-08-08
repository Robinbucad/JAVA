package com.example.relacionTablas.StudentAsignatura.infraestructure.repository;

import com.example.relacionTablas.Student.domain.Student;
import com.example.relacionTablas.StudentAsignatura.domain.StudentAsignatura;
import com.example.relacionTablas.StudentAsignatura.infraestructure.controller.output.StudentAsignaturaOutputDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentAsignaturaRepository extends JpaRepository<StudentAsignatura,String> {

    StudentAsignaturaOutputDto findStudentAsignaturaByIdAsignatura(String idAsignatura);
    StudentAsignatura findByIdAsignatura(String idAsignatura);

    List<StudentAsignatura> findStudentAsignaturaByStudentList(String idStudent);

}
