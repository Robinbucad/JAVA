package com.example.refactorCRUDbp.Profesor.domain;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String idProfesor;

    private String idPersona; // Relacion one to one tabla persona
    private String comments;

    @NotNull
    private String branch; // Materia que imparte

}
