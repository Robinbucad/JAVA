package com.example.relacionTablas.StudentAsignatura.domain;


import com.example.relacionTablas.Persona.domain.Persona;
import com.example.relacionTablas.SequenceIdGenerator.StringPrefixedSequenceIdGenerator;
import com.example.relacionTablas.Student.domain.Student;
import com.example.relacionTablas.StudentAsignatura.infraestructure.controller.input.StudentAsignaturaInputDto;
import com.example.relacionTablas.StudentAsignatura.infraestructure.controller.output.StudentAsignaturaOutputDto;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class StudentAsignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studasig")
    @GenericGenerator(
            name = "studasig",
            strategy = "com.example.relacionTablas.SequenceIdGenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            }
    )
    private String idAsignatura;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Student student;

    private String asignatura;
    private String comments;
    private Date initial_date;
    private Date finish_date;

    @OneToOne
    @JoinColumn(name = "id_persona" )
    private Persona persona;

    @ManyToMany
    private List<Student> studentList;

    public StudentAsignatura(StudentAsignaturaInputDto student, Persona persona){
        setAsignatura(student.getAsignatura());
        setComments(student.getComments());
        setInitial_date(student.getInitial_date());
        setFinish_date(student.getFinish_date());
        setPersona(persona);
    }

    public StudentAsignatura(){}

    public void update(StudentAsignaturaInputDto student){
        if (student.getAsignatura() != null){
            setAsignatura(student.getAsignatura());
        }
        if (student.getComments()!= null){
            setComments(student.getComments());
        }
        setFinish_date(student.getFinish_date());
        setInitial_date(student.getFinish_date());
    }

}
