package com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller;


import com.example.refactorCRUDbp.Estudiante_asignatura.application.EstAsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DelAsignatura {

    @Autowired
    EstAsignaturaService estAsignaturaService;

    @DeleteMapping("/estAsignatura/{idAsignatura}")
    public String deleteAsignatura(@PathVariable String idAsignatura){

           return estAsignaturaService.deleteAsignatura(idAsignatura);

    }

}
