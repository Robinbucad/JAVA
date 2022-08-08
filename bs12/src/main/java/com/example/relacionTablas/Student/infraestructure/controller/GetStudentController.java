package com.example.relacionTablas.Student.infraestructure.controller;


import com.example.relacionTablas.Student.application.StudentService;
import com.example.relacionTablas.Student.infraestructure.controller.output.FullStudentOutputDto;
import com.example.relacionTablas.Student.infraestructure.controller.output.StudentOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetStudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/hola")
    public String getAdios(){
        return "adios";
    }

    @GetMapping("/student")
    public ResponseEntity<Object> getAllStudents(){
        try {
             List<StudentOutputDto> listStudents = studentService.getAllStudents();
             return new ResponseEntity<>(listStudents, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al traer la lista de estudiantes", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/student/{idStudent}")
    public ResponseEntity<Object> getStudentById(@PathVariable String idStudent, @RequestParam(defaultValue = "simple") String type){

        if (type.equals("simple")){
            try {

                StudentOutputDto studentOutputDto = studentService.findStudentById(idStudent);
                return new ResponseEntity<>(studentOutputDto, HttpStatus.OK);

            }catch (Exception e){
                return new ResponseEntity<>("Estudiante no existe", HttpStatus.NOT_FOUND);
            }
        }else if (type.equals("full")){
            try {

                FullStudentOutputDto fullStudentOutputDto = studentService.findFullStudentById(idStudent);
                return new ResponseEntity<>(fullStudentOutputDto, HttpStatus.OK);

            }catch (Exception e){
                return new ResponseEntity<>("Estudiante no existe", HttpStatus.NOT_FOUND);
            }
        }
        else return null;

    }

    @GetMapping("/student/asignaturas/{idStudent}")
    public ResponseEntity<Object> getAsignaturasStudent(@PathVariable String idStudent){
        return new ResponseEntity<>(studentService.getAsignaturasStudent(idStudent), HttpStatus.OK);
    }

}
