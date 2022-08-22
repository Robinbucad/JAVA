package com.example.refactorCRUDbp.Student.infraestructure.controller.output;


import com.example.refactorCRUDbp.Estudiante_asignatura.domain.EstudianteAsignatura;
import com.example.refactorCRUDbp.Persona.domain.Persona;
import com.example.refactorCRUDbp.Student.domain.Student;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentOutputDTO {

    private String idStudent;
    private int numHoursWeek;
    private String comments;
    private String branch;
    private String idPersona;

    public StudentOutputDTO(Student student){
        setIdStudent(student.getIdStudent());
        setNumHoursWeek(student.getNumHoursWeek());
        setComments(student.getComments());
        setBranch(student.getBranch());
        setIdPersona(student.getPersona().getIdPersona());
    }

    public StudentOutputDTO(){

    }


}
