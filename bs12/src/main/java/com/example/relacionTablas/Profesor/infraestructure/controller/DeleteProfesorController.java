package com.example.relacionTablas.Profesor.infraestructure.controller;

import com.example.relacionTablas.Profesor.application.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteProfesorController {

    @Autowired
    ProfesorService profesorService;

    @DeleteMapping("/profesor/{idProfesor}")
    public ResponseEntity<String> deleteProfesor(@PathVariable String idProfesor){
        try {
            return new ResponseEntity<>(profesorService.deleteProfesor(idProfesor), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Profesor no existe", HttpStatus.NOT_FOUND);
        }
    }
}
