package com.example.refactorCRUDbp.Profesor.application;

import com.example.refactorCRUDbp.Profesor.infraestructure.controller.input.ProfesorInputDTO;
import com.example.refactorCRUDbp.Profesor.infraestructure.controller.output.ProfesorOutputDTO;
import com.example.refactorCRUDbp.Profesor.infraestructure.controller.output.ProfesorPersonaOutputDTO;

import java.util.List;

public interface IProfesor {

    List<ProfesorOutputDTO> getALlProfesores();
    ProfesorOutputDTO createProfesor(ProfesorInputDTO profesorInputDTO) throws Exception;
    String deleteProfesor(String idProfesor);

    ProfesorPersonaOutputDTO getFullProfesor(String idProfesor)throws Exception;

    ProfesorOutputDTO getProfesorById(String idProfesor)throws Exception;


}
