package com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.output;

import com.example.refactorCRUDbp.Estudiante_asignatura.domain.EstudianteAsignatura;
import lombok.Data;

import java.util.Date;

@Data
public class EstAsignaturaOutputDTO {

    private String idAsignatura;
    private String asignatura;
    private String comments;
    private Date initialDate;
    private Date finishDate;
    private String idStudent;

    public EstAsignaturaOutputDTO(EstudianteAsignatura estudianteAsignatura){

        setIdAsignatura(estudianteAsignatura.getIdAsignatura());
        setAsignatura(estudianteAsignatura.getAsignatura());
        setComments(estudianteAsignatura.getComments());
        setInitialDate(estudianteAsignatura.getInitialDate());
        setFinishDate(estudianteAsignatura.getFinishDate());
        setIdStudent(estudianteAsignatura.getIdStudent());

    }
    public EstAsignaturaOutputDTO(){
    }

}
