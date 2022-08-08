package com.example.relacionTablas.Student.domain;


import com.example.relacionTablas.Persona.domain.Persona;
import com.example.relacionTablas.SequenceIdGenerator.StringPrefixedSequenceIdGenerator;
import com.example.relacionTablas.Student.infraestructure.controller.input.StudentInputDto;
import com.example.relacionTablas.StudentAsignatura.domain.StudentAsignatura;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "students")
    @GenericGenerator(
            name = "students",
            strategy = "com.example.relacionTablas.SequenceIdGenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            }
    )
    private String idStudent;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    private int num_hours_week;
    private String comments;

    private String branch;

    @ManyToMany
    @JoinColumn(name = "asignaturas")
    private List<StudentAsignatura> asignaturas;

    public Student(StudentInputDto studentInputDto, Persona persona){

        setComments(studentInputDto.getComments());
        setBranch(studentInputDto.getBranch());
        setNum_hours_week(studentInputDto.getNum_hours_week());
        setPersona(persona);
    }

    public Student(){}



    public void update(StudentInputDto studentInputDto){

            if (studentInputDto.getBranch() != null){
                setBranch(studentInputDto.getBranch());

            }
            if (studentInputDto.getComments()!= null){
                setComments(studentInputDto.getComments());

            }
            if (studentInputDto.getNum_hours_week() != 0){
                setNum_hours_week(studentInputDto.getNum_hours_week());

            }

    }

}
