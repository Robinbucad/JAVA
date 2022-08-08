package com.example.relacionTablas.StudentAsignatura.infraestructure.controller;


import com.example.relacionTablas.StudentAsignatura.application.StudentAsignaturaService;
import com.example.relacionTablas.StudentAsignatura.infraestructure.controller.input.StudentAsignaturaInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PutStudentAsignaturaController {

    @Autowired
    StudentAsignaturaService studentAsignaturaService;

    @PutMapping("/estAsign/{idAsignatura}")
    public ResponseEntity<Object> updateStudentAsignatura(@PathVariable String idAsignatura, @RequestBody StudentAsignaturaInputDto student){
        try {
            return new ResponseEntity<>(studentAsignaturaService.updateStudentAsignatura(idAsignatura,student), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al actualizar estudiante asignatura", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
