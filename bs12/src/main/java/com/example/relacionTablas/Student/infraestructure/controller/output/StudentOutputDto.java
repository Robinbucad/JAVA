package com.example.relacionTablas.Student.infraestructure.controller.output;

import com.example.relacionTablas.Student.domain.Student;
import lombok.Data;

@Data
public class StudentOutputDto {


    private String idStudent;
    private int num_hours_week;
    private String comments;
    private String branch;
    private String idPersona;

    public StudentOutputDto(Student student){
        setIdPersona(student.getPersona().getIdPersona());
        setIdStudent(student.getIdStudent());
        setNum_hours_week(student.getNum_hours_week());
        setComments(student.getComments());
        setBranch(student.getBranch());
    }

    public StudentOutputDto(){}

}
