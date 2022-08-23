package com.example.refactorCRUDbp.Profesor.infraestructure.controller.input;


import com.example.refactorCRUDbp.Estudiante_asignatura.domain.EstudianteAsignatura;
import com.example.refactorCRUDbp.Persona.domain.Persona;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProfesorInputDTO {

    private String comments;
    private String branch;
    private String idPersona;
    private String idAsignatura;
    private List<EstudianteAsignatura> estudianteAsignaturas = new ArrayList<>();

    public ProfesorInputDTO() {

    }
}
