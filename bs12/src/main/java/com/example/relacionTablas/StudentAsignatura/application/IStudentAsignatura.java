package com.example.relacionTablas.StudentAsignatura.application;

import com.example.relacionTablas.Student.infraestructure.controller.output.StudentOutputDto;
import com.example.relacionTablas.StudentAsignatura.infraestructure.controller.input.StudentAsignaturaInputDto;
import com.example.relacionTablas.StudentAsignatura.infraestructure.controller.output.StudentAsignaturaOutputDto;

import java.util.List;

public interface IStudentAsignatura {

    List<StudentAsignaturaOutputDto> getAllStudentAsignatura();

    StudentAsignaturaOutputDto createStudentAsginatura(StudentAsignaturaInputDto studentAsignaturaInputDto);

    StudentAsignaturaOutputDto findStudentAsignaturaByIdAsignatura(String idAsignatura);

    StudentAsignaturaOutputDto updateStudentAsignatura(String idAsignatura, StudentAsignaturaInputDto student);

    String deleteStudentAsignatura(String idAsignatura);
}
