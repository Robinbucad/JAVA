package com.example.relacionTablas.StudentAsignatura.infraestructure.controller.input;

import lombok.Data;

import java.util.Date;

@Data
public class StudentAsignaturaInputDto {

    private String asignatura;
    private String comments;
    private Date initial_date;
    private Date finish_date;
    private String idPersona;

}
