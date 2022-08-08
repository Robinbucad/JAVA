package com.example.refactorCRUDbp.Profesor.infraestructure.controller;


import com.example.refactorCRUDbp.Profesor.application.ProfesorService;
import com.example.refactorCRUDbp.Profesor.infraestructure.controller.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController

public class GetProfesorController {


    @Autowired
    ProfesorService profesorService;

    @GetMapping("/profesor")
    public List<ProfesorOutputDTO> getALlProfesores(){
        return profesorService.getALlProfesores();
    }

    @GetMapping("/profesor/{id}")
    ResponseEntity<ProfesorOutputDTO> getProfesorById(@PathVariable String id){
        ResponseEntity<ProfesorOutputDTO> profesor = new RestTemplate().getForEntity("http://localhost:8081/"+ id, ProfesorOutputDTO.class);
        return ResponseEntity.ok(profesor.getBody());
    }
}
