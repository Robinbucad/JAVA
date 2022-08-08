package com.example.relacionTablas.Student.infraestructure.controller;


import com.example.relacionTablas.Student.application.StudentService;
import com.example.relacionTablas.Student.infraestructure.controller.input.StudentInputDto;
import com.example.relacionTablas.Student.infraestructure.controller.output.StudentOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PutStudentController {

    @Autowired
    StudentService studentService;

    @PutMapping("/student/{idStudent}")
    public ResponseEntity<Object> updateStudent(@PathVariable String idStudent, @RequestBody StudentInputDto studentInputDto){
        try {
            StudentOutputDto studentOutputDto = studentService.updateStudent(idStudent,studentInputDto);
            return new ResponseEntity<>(studentOutputDto, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al acutalizar estudiante", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
