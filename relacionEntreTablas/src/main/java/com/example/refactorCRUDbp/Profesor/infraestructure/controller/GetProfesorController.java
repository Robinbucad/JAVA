package com.example.refactorCRUDbp.Profesor.infraestructure.controller;


import com.example.refactorCRUDbp.Profesor.application.ProfesorService;
import com.example.refactorCRUDbp.Profesor.infraestructure.controller.output.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetProfesorController {


    @Autowired
    ProfesorService profesorService;

    @GetMapping("/profesor")
    public List<ProfesorOutputDTO> getALlProfesores(){
        return profesorService.getALlProfesores();
    }
}
