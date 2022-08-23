package com.example.refactorCRUDbp.Persona.infraestructure.controler;


import com.example.refactorCRUDbp.Persona.application.PersonaService;
import com.example.refactorCRUDbp.Persona.domain.Roles;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.output.PersonaOutputDTO;
import com.example.refactorCRUDbp.Student.application.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GetPersonasController {

    @Autowired
    PersonaService personaService;

    @Autowired
    StudentService studentService;

    @GetMapping("/pong")
    public String getPing(){
        return "Ping";
    }


    @GetMapping("/user")
    public List<PersonaOutputDTO> getALlPersonas(){
        return personaService.getALlPersonas();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/id/{idPersona}")
    public Object getUserByID(@PathVariable String idPersona, @RequestParam(defaultValue = "simple") String type){

            if (type.equals("simple")){
               return personaService.getUserByID(idPersona);
            }
            else if (type.equals("full")){
                return studentService.getStudentPersona(idPersona);
            }
            else {
                return null;
            }
    }

    @GetMapping("/user/username/{username}")
    public Object getPersonaByUsername(@PathVariable String username, @RequestParam(defaultValue = "simple") String type){
            if (type.equals("simple")){
               return personaService.findByUsername(username);
            }
            else if (type.equals("full")){
                return studentService.getStudentPersona(username);
            }
            else {
                return null;
            }

    }

    @GetMapping("/roles")
    public List<Roles> getRoles(){
        return personaService.getRoles();
    }
}

