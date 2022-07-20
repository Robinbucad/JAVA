package com.example.refactorCRUDbp.Student.application;

import com.example.refactorCRUDbp.Student.domain.Student;
import com.example.refactorCRUDbp.Student.infraestructure.controller.input.StudentInputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentOutputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentPersonaOutputDTO;

import java.util.List;
import java.util.Optional;

public interface IStudent {

   List<StudentOutputDTO> getALlStudents();

   StudentOutputDTO createStudent(StudentInputDTO studentInputDTO);
   StudentOutputDTO getStudentById(String idStudent) throws Exception;

   StudentPersonaOutputDTO getStudentPersona(String idStudent) throws Exception;
}
