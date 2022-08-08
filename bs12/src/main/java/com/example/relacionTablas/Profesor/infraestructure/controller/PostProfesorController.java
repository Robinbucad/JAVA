package com.example.relacionTablas.Profesor.infraestructure.controller;


import com.example.relacionTablas.Profesor.application.ProfesorService;
import com.example.relacionTablas.Profesor.infraestructure.controller.input.ProfesorInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostProfesorController {

    @Autowired
    ProfesorService profesorService;

    @PostMapping("/profesor")
    public ResponseEntity<Object> createProfesor(@RequestBody ProfesorInputDto profesor) throws Exception{
        try {
            return new ResponseEntity<>(profesorService.createProfesor(profesor), HttpStatus.OK);
        }catch (Exception e){
            System.out.println(profesor);
            return new ResponseEntity<>(profesorService.createProfesor(profesor), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
