package com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller;


import com.example.refactorCRUDbp.Estudiante_asignatura.application.EstAsignaturaService;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.output.EstAsignaturaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAsignaturaController {

    @Autowired
    EstAsignaturaService estAsignaturaService;



    @GetMapping("/estAsignatura")
    List<EstAsignaturaOutputDTO> getAllAsignaturas(){
        return estAsignaturaService.getAllAsignaturas();
    }

    @GetMapping("/estAsignatura/{idAsignatura}")
    EstAsignaturaOutputDTO getEstAsignaturaById(@PathVariable String idAsignatura){
       return estAsignaturaService.getEstAsignaturaById(idAsignatura);

    }


}
