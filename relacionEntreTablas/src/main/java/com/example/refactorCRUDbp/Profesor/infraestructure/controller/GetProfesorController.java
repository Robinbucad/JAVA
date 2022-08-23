package com.example.refactorCRUDbp.Profesor.infraestructure.controller;


import com.example.refactorCRUDbp.Profesor.application.ProfesorService;
import com.example.refactorCRUDbp.Profesor.infraestructure.controller.output.ProfesorOutputDTO;
import com.example.refactorCRUDbp.Profesor.infraestructure.controller.output.ProfesorPersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Object getProfesorById(@PathVariable String id, @RequestParam(defaultValue = "simple") String type){

            if (type.equals("simple")){
                return profesorService.getProfesorById(id);
            }
            if (type.equals("full")){
                return profesorService.getFullProfesor(id);
            }else {
                return null;
            }
    }
}
