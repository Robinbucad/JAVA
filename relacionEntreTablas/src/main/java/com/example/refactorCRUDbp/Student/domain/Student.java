package com.example.refactorCRUDbp.Student.domain;

import com.example.refactorCRUDbp.Persona.domain.Persona;
import com.example.refactorCRUDbp.SequenceIdGenerator.StringPrefixedSequenceIdGenerator;
import com.example.refactorCRUDbp.Student.infraestructure.controller.input.StudentInputDTO;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "student")
@Data
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

    @OneToOne(fetch = FetchType.EAGER)
    Persona persona; //Relacion one to one con tabla persona


    private int numHoursWeek;
    private String comments;

    private String idProfesor; // Un estudiante solo puede tener un profesor


    private String branch; // Rama principal estudiante -front, back, fullstack

    public Student(StudentInputDTO studentInputDTO){
        setNumHoursWeek(studentInputDTO.getNumHoursWeek());
        setComments(studentInputDTO.getComments());
        setBranch(studentInputDTO.getBranch());
    }

    public Student(){

    }

}
