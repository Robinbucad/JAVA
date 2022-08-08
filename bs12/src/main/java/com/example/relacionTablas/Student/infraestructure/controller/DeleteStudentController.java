package com.example.relacionTablas.Student.infraestructure.controller;


import com.example.relacionTablas.Student.application.StudentService;
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
    public ResponseEntity<Object> deleteStudent(@PathVariable String idStudent){
        try {
            return new ResponseEntity<>(studentService.deleteStudent(idStudent), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al borrar estudiante", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
