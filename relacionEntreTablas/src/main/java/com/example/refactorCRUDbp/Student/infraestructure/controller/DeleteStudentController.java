package com.example.refactorCRUDbp.Student.infraestructure.controller;


import com.example.refactorCRUDbp.Student.application.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteStudentController {

    @Autowired
    StudentService studentService;

    @DeleteMapping("/student/{idStudent}")
    public String deleteStudentById(@PathVariable String idStudent) {
            return studentService.deleteStudentById(idStudent);
    }

}
