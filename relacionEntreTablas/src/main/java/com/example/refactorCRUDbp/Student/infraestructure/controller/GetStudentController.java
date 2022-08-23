package com.example.refactorCRUDbp.Student.infraestructure.controller;


import com.example.refactorCRUDbp.Student.application.StudentService;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetStudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student")
    public List<StudentOutputDTO> getAllStudents(){
        return studentService.getALlStudents();
    }

    @GetMapping("/student/{id}")
    public Object getStudentById(@PathVariable String id, @RequestParam(defaultValue = "simple") String type) {

            if (type.equals("simple")){
                return studentService.getStudentById(id);
            }
            else if (type.equals("full")){
                return studentService.getStudentPersona(id);
            }else {
                return null;
            }

    }



}
