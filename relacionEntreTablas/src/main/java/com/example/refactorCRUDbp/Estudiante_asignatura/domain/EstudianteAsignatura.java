package com.example.refactorCRUDbp.Estudiante_asignatura.domain;

import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.input.EstAsignaturaInputDTO;
import com.example.refactorCRUDbp.SequenceIdGenerator.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "EstudiantesAsignatura")
public class EstudianteAsignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asignatura")
    @GenericGenerator(
            name = "asignatura",
            strategy = "com.example.refactorCRUDbp.SequenceIdGenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),

            }
    )
    private String idAsignatura;
    private String idStudent;
    private String asignatura;
    private String comments;
    private Date initialDate;
    private Date finishDate;

    public EstudianteAsignatura(EstAsignaturaInputDTO estAsignaturaInputDTO){
        setAsignatura(estAsignaturaInputDTO.getAsignatura());
        setComments(estAsignaturaInputDTO.getComments());
        setInitialDate(estAsignaturaInputDTO.getInitialDate());
        setFinishDate(estAsignaturaInputDTO.getFinishDate());
    }

    public EstudianteAsignatura(){

    }

}
