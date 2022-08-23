package com.example.refactorCRUDbp.Student.infraestructure.controller;

import com.example.refactorCRUDbp.Student.application.StudentService;
import com.example.refactorCRUDbp.Student.infraestructure.controller.input.StudentInputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatchStudentController {


    @Autowired
    StudentService studentService;

    @PatchMapping("/student/{idStudent}")
    public StudentOutputDTO updateStudent(@RequestBody StudentInputDTO studentInputDTO, @PathVariable String idStudent){
            return studentService.updateStudent(studentInputDTO,idStudent);
    }

}
