package com.example.refactorCRUDbp.Estudiante_asignatura.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "EstudiantesAsignatura")
public class EstudianteAsignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idAsignatura;
    private String idStudent;

    private String asignatura;
    private String comments;
    private Date initialDate;
    private Date finishDate;

}
