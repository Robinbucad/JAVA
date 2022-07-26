package com.example.refactorCRUDbp.Profesor.infraestructure.controller.output;

import com.example.refactorCRUDbp.Profesor.domain.Profesor;
import lombok.Data;


@Data
public class ProfesorOutputDTO {

    private String idProfesor;
    private String comments;
    private String branch;

    public ProfesorOutputDTO(Profesor profesor){

        setIdProfesor(profesor.getIdProfesor());
        setBranch(profesor.getBranch());
        setComments(profesor.getComments());

    }

}
