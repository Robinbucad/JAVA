package com.example.refactorCRUDbp.Student.infraestructure.controller;


import com.example.refactorCRUDbp.Student.application.StudentService;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetStudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student")
    public List<StudentOutputDTO> getAlStudents(){
        return studentService.getALlStudents();
    }


}
