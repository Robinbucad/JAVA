package com.example.relacionTablas.StudentAsignatura.infraestructure.controller;


import com.example.relacionTablas.StudentAsignatura.application.StudentAsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetStudentAsignaturaController {

    @Autowired
    StudentAsignaturaService studentAsignaturaService;

    @GetMapping("/estAsign")
    public ResponseEntity<Object> getAllStudentAsignatura(){
        return new ResponseEntity<>(studentAsignaturaService.getAllStudentAsignatura(), HttpStatus.OK);
    }

    @GetMapping("/estAsign/{idAsignatura}")
    public ResponseEntity<Object> getStudentAsignaturaById(@PathVariable String idAsignatura ){
        try {

            return new ResponseEntity<>(studentAsignaturaService.findStudentAsignaturaByIdAsignatura(idAsignatura), HttpStatus.OK);

        }catch (Exception e){
            System.out.println(studentAsignaturaService.findStudentAsignaturaByIdAsignatura(idAsignatura));
            return new ResponseEntity<>("Asignatura no existe", HttpStatus.NOT_FOUND);
        }
    }

}
