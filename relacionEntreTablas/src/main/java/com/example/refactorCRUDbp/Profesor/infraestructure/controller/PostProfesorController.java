package com.example.refactorCRUDbp.Profesor.infraestructure.controller;


import com.example.refactorCRUDbp.Profesor.application.ProfesorService;
import com.example.refactorCRUDbp.Profesor.infraestructure.controller.input.ProfesorInputDTO;
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
    public ResponseEntity<Object> createProfesor(@RequestBody ProfesorInputDTO profesorInputDTO){
        try {
            profesorService.createProfesor(profesorInputDTO);
            return new ResponseEntity<>(profesorInputDTO, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>("Error el crear el profesor", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
