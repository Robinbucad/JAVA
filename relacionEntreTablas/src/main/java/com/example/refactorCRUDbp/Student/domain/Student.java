package com.example.refactorCRUDbp.Student.domain;

import com.example.refactorCRUDbp.Estudiante_asignatura.domain.EstudianteAsignatura;
import com.example.refactorCRUDbp.Persona.domain.Persona;
import com.example.refactorCRUDbp.SequenceIdGenerator.StringPrefixedSequenceIdGenerator;
import com.example.refactorCRUDbp.Student.infraestructure.controller.input.StudentInputDTO;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "students")
    @GenericGenerator(
            name = "students",
            strategy = "com.example.refactorCRUDbp.SequenceIdGenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),

            }
    )
    private String idStudent;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idPersona")
    Persona persona; //Relacion one to one con tabla persona


    private int numHoursWeek;
    private String comments;


    private String idProfesor; // Un estudiante solo puede tener un profesor


    private String branch; // Rama principal estudiante -front, back, fullstack

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<EstudianteAsignatura> estudianteAsignaturas = new ArrayList<>();

    public Student(StudentInputDTO studentInputDTO, Persona persona){
        setNumHoursWeek(studentInputDTO.getNumHoursWeek());
        setComments(studentInputDTO.getComments());
        setBranch(studentInputDTO.getBranch());
        setPersona(persona);
        setEstudianteAsignaturas(studentInputDTO.getEstudianteAsignaturas());
    }

    public Student(){

    }

}
