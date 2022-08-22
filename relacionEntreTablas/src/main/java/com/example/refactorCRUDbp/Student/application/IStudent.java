package com.example.refactorCRUDbp.Student.application;

import com.example.refactorCRUDbp.Persona.domain.Persona;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.input.PersonaInputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.controller.input.StudentInputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentOutputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentPersonaOutputDTO;

import java.util.List;

public interface IStudent {

   List<StudentOutputDTO> getALlStudents();

   StudentOutputDTO createStudent(StudentInputDTO studentInputDTO) throws Exception;
   StudentOutputDTO getStudentById(String idStudent) throws Exception;

   StudentPersonaOutputDTO getStudentPersona(String idStudent) throws Exception;

   StudentOutputDTO updateStudent(StudentInputDTO studentInputDTO, String idStudent);
}
