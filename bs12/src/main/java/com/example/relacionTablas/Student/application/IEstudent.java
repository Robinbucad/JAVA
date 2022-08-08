package com.example.relacionTablas.Student.application;

import com.example.relacionTablas.Student.infraestructure.controller.input.StudentInputDto;
import com.example.relacionTablas.Student.infraestructure.controller.output.StudentOutputDto;
import com.example.relacionTablas.StudentAsignatura.infraestructure.controller.output.StudentAsignaturaOutputDto;

import java.util.List;

public interface IEstudent {

    List<StudentOutputDto> getAllStudents();

    StudentOutputDto createStudent(StudentInputDto studentInputDto);

    StudentOutputDto findStudentById(String idStudent);

    String deleteStudent(String idStudent);

    List<StudentAsignaturaOutputDto> getAsignaturasStudent(String idPersona);


    }
