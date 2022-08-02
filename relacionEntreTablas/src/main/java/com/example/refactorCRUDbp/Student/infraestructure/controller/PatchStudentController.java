package com.example.refactorCRUDbp.Student.infraestructure.controller;

import com.example.refactorCRUDbp.Student.application.StudentService;
import com.example.refactorCRUDbp.Student.infraestructure.controller.input.StudentInputDTO;
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
    public ResponseEntity<Object> updateStudent(@RequestBody StudentInputDTO studentInputDTO, @PathVariable String idStudent){
        try {

            studentService.updateStudent(studentInputDTO,idStudent);
            return new ResponseEntity<>(studentInputDTO,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>("Error al actualizar estudante", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
