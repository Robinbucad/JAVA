package com.example.relacionTablas.Profesor.infraestructure.controller;


import com.example.relacionTablas.Profesor.application.ProfesorService;
import com.example.relacionTablas.Profesor.infraestructure.controller.output.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetProfesorController {

    @Autowired
    ProfesorService profesorService;

    @GetMapping("/profesor")
    public ResponseEntity<List<ProfesorOutputDto>> getAllProfesores(){
        return new ResponseEntity<>(profesorService.getAllProfesores(), HttpStatus.OK);
    }

    @GetMapping("/profesor/{idProfesor}")
    public ResponseEntity<Object> getProfesorById(@PathVariable String idProfesor){
        try {
            return new ResponseEntity<>(profesorService.getProfesorById(idProfesor), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Profesor no existe", HttpStatus.NOT_FOUND);
        }
    }

}
