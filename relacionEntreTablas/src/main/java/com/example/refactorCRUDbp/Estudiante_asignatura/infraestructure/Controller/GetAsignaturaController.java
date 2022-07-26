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
    ResponseEntity<Object> getAllAsignaturas(){
        try {
            List<EstAsignaturaOutputDTO> estAsignaturaOutputDTO= estAsignaturaService.getAllAsignaturas();
            return new ResponseEntity<>(estAsignaturaOutputDTO, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al recoger todas las asignaturas", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/estAsignatura/{idAsignatura}")
    ResponseEntity<Object> getEstAsignaturaById(@PathVariable String idAsignatura){
        try {
            EstAsignaturaOutputDTO estAsignaturaOutputDTO= estAsignaturaService.getEstAsignaturaById(idAsignatura);
            return new ResponseEntity<>(estAsignaturaOutputDTO, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("No existe la asignatura", HttpStatus.NOT_FOUND);
        }
    }

}
