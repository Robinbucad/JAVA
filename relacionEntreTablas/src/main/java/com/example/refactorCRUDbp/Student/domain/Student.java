package com.example.refactorCRUDbp.Student.domain;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "estudiantes")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String idStudent;
    private String idPersona; //Relacion one to one con tabla persona

    @NotNull
    private int numHoursWeek;
    private String comments;

    private String idProfesor; // Un estudiante solo puede tener un profesor

    @NotNull
    private String branch; // Rama principal estudiante -front, back, fullstack

}
