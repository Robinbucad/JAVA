package com.example.relacionTablas.Profesor.application;

import com.example.relacionTablas.Profesor.domain.Profesor;
import com.example.relacionTablas.Profesor.infraestructure.controller.input.ProfesorInputDto;
import com.example.relacionTablas.Profesor.infraestructure.controller.output.ProfesorOutputDto;

import java.util.List;

public interface IProfesor {

    ProfesorOutputDto createProfesor(ProfesorInputDto profesor) throws Exception;

    List<ProfesorOutputDto> getAllProfesores();
    
    ProfesorOutputDto getProfesorById(String idProfesor);

    String deleteProfesor(String idProfesor);
}
