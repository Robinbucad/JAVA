package com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller;


import com.example.refactorCRUDbp.Estudiante_asignatura.application.EstAsignaturaService;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.input.EstAsignaturaInputDTO;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.output.EstAsignaturaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatchAsignaturaController {

    @Autowired
    EstAsignaturaService estAsignaturaService;

    @PatchMapping("/estAsignatura/{idAsignatura}")
    EstAsignaturaOutputDTO updateAsignatura(@RequestBody EstAsignaturaInputDTO estAsignaturaInputDTO, @PathVariable String idAsignatura){
            return estAsignaturaService.updateEstudianteAsignatura(estAsignaturaInputDTO,idAsignatura);
    }


}
