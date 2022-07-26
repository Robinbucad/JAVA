package com.example.refactorCRUDbp.Profesor.application;

import com.example.refactorCRUDbp.Profesor.infraestructure.controller.input.ProfesorInputDTO;
import com.example.refactorCRUDbp.Profesor.infraestructure.controller.output.ProfesorOutputDTO;

import java.util.List;

public interface IProfesor {

    List<ProfesorOutputDTO> getALlProfesores();
    ProfesorOutputDTO createProfesor(ProfesorInputDTO profesorInputDTO);

}
