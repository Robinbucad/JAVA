package com.example.refactorCRUDbp.Student.infraestructure.controller;


import com.example.refactorCRUDbp.Student.application.StudentService;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentOutputDTO;
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
    public ResponseEntity<Object> deleteStudentById(@PathVariable String idStudent) {
        try {
            studentService.deleteStudentById(idStudent);
            return new ResponseEntity<>("Borrada correctamente", HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>("Estudiante no existe", HttpStatus.NOT_FOUND);
        }
    }

}
