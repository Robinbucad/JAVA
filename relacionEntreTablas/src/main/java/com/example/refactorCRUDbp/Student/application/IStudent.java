package com.example.refactorCRUDbp.Student.application;

import com.example.refactorCRUDbp.Persona.domain.Persona;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.input.PersonaInputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.controller.input.StudentInputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentOutputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentPersonaOutputDTO;

import java.util.List;

public interface IStudent {

   List<StudentOutputDTO> getALlStudents();

   StudentOutputDTO createStudent(StudentInputDTO studentInputDTO);
   StudentOutputDTO getStudentById(String idStudent);

   StudentPersonaOutputDTO getStudentPersona(String idStudent);

   StudentOutputDTO updateStudent(StudentInputDTO studentInputDTO, String idStudent);

   String deleteStudentById(String idStudent);
}
