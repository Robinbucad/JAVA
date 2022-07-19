package com.example.refactorCRUDbp.Student.infraestructure.controller.output;


import com.example.refactorCRUDbp.Student.domain.Student;
import lombok.Data;

@Data
public class StudentOutputDTO {

    private String idStudent;
    private int numHoursWeek;
    private String comments;
    private String branch;

    public StudentOutputDTO(Student student){
        setNumHoursWeek(student.getNumHoursWeek());
        setComments(student.getComments());
        setBranch(student.getBranch());
    }

    public StudentOutputDTO(){

    }

}
