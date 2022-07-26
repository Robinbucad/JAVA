package com.example.refactorCRUDbp.Student.infraestructure.controller.input;


import com.example.refactorCRUDbp.Persona.domain.Persona;
import lombok.Data;

@Data
public class StudentInputDTO {
    private int numHoursWeek;
    private String comments;
    private String branch;
    private String idStudent;
    private Persona idPersona;
    public StudentInputDTO(){

    }
}
