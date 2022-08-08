package com.example.relacionTablas.StudentAsignatura.infraestructure.controller;

import com.example.relacionTablas.StudentAsignatura.application.StudentAsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteStudentAsignaturaController {

    @Autowired
    StudentAsignaturaService studentAsignaturaService;

    @DeleteMapping("/estAsign/{idAsignatura}")
    public ResponseEntity<String> deleteStudentAsignatura(@PathVariable String idAsignatura){
        try {
            return new ResponseEntity<>(studentAsignaturaService.deleteStudentAsignatura(idAsignatura), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al borrar estudiante asignatura", HttpStatus.NOT_FOUND);
        }
    }
}
