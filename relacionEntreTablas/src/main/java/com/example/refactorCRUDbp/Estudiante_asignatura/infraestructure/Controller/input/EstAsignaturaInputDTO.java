package com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.input;

import com.example.refactorCRUDbp.Estudiante_asignatura.domain.EstudianteAsignatura;
import lombok.Data;
import org.aspectj.apache.bcel.classfile.Module;

import java.util.Date;

@Data
public class EstAsignaturaInputDTO  {


    private String asignatura;
    private String comments;
    private Date initialDate;
    private Date finishDate;
    private String idStudent;
    private String idProfesor;

    public EstAsignaturaInputDTO(){}

}
