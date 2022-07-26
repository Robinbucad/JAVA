package com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller;


import com.example.refactorCRUDbp.Estudiante_asignatura.application.EstAsignaturaService;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.input.EstAsignaturaInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostAsignaturaController {

    @Autowired
    EstAsignaturaService estAsignaturaService;

    @PostMapping("estAsignatura")
    ResponseEntity<Object> createAsignatura(@RequestBody EstAsignaturaInputDTO estAsignaturaInputDTO){
        try {
            estAsignaturaService.createAsignatura(estAsignaturaInputDTO);
            return new ResponseEntity<>(estAsignaturaInputDTO, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error al crear asignatura", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
