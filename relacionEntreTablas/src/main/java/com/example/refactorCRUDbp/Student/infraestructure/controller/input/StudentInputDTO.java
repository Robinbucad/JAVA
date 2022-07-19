package com.example.refactorCRUDbp.Student.infraestructure.controller.input;


import lombok.Data;

@Data
public class StudentInputDTO {
    private int numHoursWeek;
    private String comments;
    private String branch;

}
