package com.example.relacionTablas.Student.infraestructure.controller.input;


import com.example.relacionTablas.Persona.domain.Persona;
import lombok.Data;

@Data
public class StudentInputDto {

    private String idPersona;
    private int num_hours_week;
    private String comments;
    private String branch;

    public StudentInputDto(){}

}
