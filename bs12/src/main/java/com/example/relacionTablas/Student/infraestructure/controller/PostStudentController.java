package com.example.relacionTablas.Student.infraestructure.controller;


import com.example.relacionTablas.Student.application.StudentService;
import com.example.relacionTablas.Student.infraestructure.controller.input.StudentInputDto;
import com.example.relacionTablas.Student.infraestructure.controller.output.StudentOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostStudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<Object> createStudent(@RequestBody StudentInputDto studentInputDto){
        try{
            StudentOutputDto newStudent = studentService.createStudent(studentInputDto);
            return new ResponseEntity<>(newStudent, HttpStatus.OK);

        } catch (Exception e){

            return new ResponseEntity<>("error al crear estudiante", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


}
