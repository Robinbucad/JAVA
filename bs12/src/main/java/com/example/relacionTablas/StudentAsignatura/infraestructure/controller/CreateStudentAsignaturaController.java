package com.example.relacionTablas.StudentAsignatura.infraestructure.controller;


import com.example.relacionTablas.Student.infraestructure.controller.input.StudentInputDto;
import com.example.relacionTablas.Student.infraestructure.controller.output.StudentOutputDto;
import com.example.relacionTablas.StudentAsignatura.application.StudentAsignaturaService;
import com.example.relacionTablas.StudentAsignatura.infraestructure.controller.input.StudentAsignaturaInputDto;
import com.example.relacionTablas.StudentAsignatura.infraestructure.controller.output.StudentAsignaturaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateStudentAsignaturaController {

    @Autowired
    StudentAsignaturaService studentAsignaturaService;

    @PostMapping("/estAsign")
    public ResponseEntity<Object> createStudentAsignatura(@RequestBody StudentAsignaturaInputDto student){
        try {
            StudentAsignaturaOutputDto studentOutputDto = studentAsignaturaService.createStudentAsginatura(student);
            return new ResponseEntity<>(studentOutputDto, HttpStatus.CREATED);

        }catch (Exception e){
            System.out.println(student);
            return new ResponseEntity<>("Error al crear la asignatura", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
