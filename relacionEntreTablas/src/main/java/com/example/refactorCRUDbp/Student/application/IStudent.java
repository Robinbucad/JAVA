package com.example.refactorCRUDbp.Student.application;

import com.example.refactorCRUDbp.Student.infraestructure.controller.input.StudentInputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentOutputDTO;

import java.util.List;

public interface IStudent {

   List<StudentOutputDTO> getALlStudents();

   StudentOutputDTO createStudent(StudentInputDTO studentInputDTO);

}
