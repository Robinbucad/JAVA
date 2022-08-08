package com.example.refactorCRUDbp.Profesor.infraestructure.controller.input;


import com.example.refactorCRUDbp.Persona.domain.Persona;
import lombok.Data;

@Data
public class ProfesorInputDTO {

    private String comments;
    private String branch;
    private Persona persona;

}
