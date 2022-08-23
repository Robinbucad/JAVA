package com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller;


import com.example.refactorCRUDbp.Estudiante_asignatura.application.EstAsignaturaService;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.input.EstAsignaturaInputDTO;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.output.EstAsignaturaOutputDTO;
import jdk.javadoc.doclet.Reporter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostAsignaturaController {

    @Autowired
    EstAsignaturaService estAsignaturaService;

    @PostMapping("estAsignatura")
    EstAsignaturaOutputDTO createAsignatura(@RequestBody EstAsignaturaInputDTO estAsignaturaInputDTO){
           return estAsignaturaService.createAsignatura(estAsignaturaInputDTO);

    }

    @PostMapping("/estAsignatura/add")
    public ResponseEntity<Object> addSubjectStudent( @RequestBody AddSubject addSubject){
        try {
            estAsignaturaService.addSubjectStudent(addSubject.getIdStudent(), addSubject.getIdAsignatura());
            return new ResponseEntity<>("Push", HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

}

@Data
class AddSubject{
    private String idAsignatura;
    private String idStudent;
}