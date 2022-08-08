package com.example.relacionTablas.StudentAsignatura.infraestructure.controller.output;

import com.example.relacionTablas.Student.domain.Student;
import com.example.relacionTablas.StudentAsignatura.domain.StudentAsignatura;
import lombok.Data;

import java.util.Date;

@Data
public class StudentAsignaturaOutputDto {

    private String idPersona;
    private String idAsignatura;
    private String asignatura;
    private String comments;
    private Date initial_date;
    private Date finish_date;

    public StudentAsignaturaOutputDto(StudentAsignatura student){
        setIdPersona(student.getPersona().getIdPersona());
        setIdAsignatura(student.getIdAsignatura());
        setAsignatura(student.getAsignatura());
        setComments(student.getComments());
        setInitial_date(student.getInitial_date());
        setFinish_date(student.getFinish_date());
    }

    public StudentAsignaturaOutputDto(){}

}
