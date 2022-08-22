package com.example.refactorCRUDbp.Student.infraestructure.controller.input;


import com.example.refactorCRUDbp.Estudiante_asignatura.domain.EstudianteAsignatura;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentInputDTO {
    private int numHoursWeek;
    private String comments;
    private String branch;
    private String idPersona;
    private List<EstudianteAsignatura> estudianteAsignaturas = new ArrayList<>();

    public StudentInputDTO(){

    }
}
