package com.example.relacionTablas.Profesor.infraestructure.controller.output;

import com.example.relacionTablas.Profesor.domain.Profesor;
import lombok.Data;

@Data
public class ProfesorOutputDto {

    private String idProfesor;
    private String idPersona;
    private String comments;
    private String branch;

    public ProfesorOutputDto(Profesor profesor){
        setIdProfesor(profesor.getIdProfesor());
        setIdPersona(profesor.getPersona().getIdPersona());
        setComments(profesor.getComments());
        setBranch(profesor.getBranch());
    }

    public ProfesorOutputDto(){}
}
