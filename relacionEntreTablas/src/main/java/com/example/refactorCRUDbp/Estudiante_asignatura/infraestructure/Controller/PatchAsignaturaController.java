package com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller;


import com.example.refactorCRUDbp.Estudiante_asignatura.application.EstAsignaturaService;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.input.EstAsignaturaInputDTO;
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
    ResponseEntity<Object> updateAsignatura(@RequestBody EstAsignaturaInputDTO estAsignaturaInputDTO, @PathVariable String idAsignatura){
        try {
            estAsignaturaService.updateEstudianteAsignatura(estAsignaturaInputDTO,idAsignatura);
            return new ResponseEntity<>(estAsignaturaInputDTO, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al actualizar asignatura", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


}
