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
    public ResponseEntity<Object> getUserByID(@PathVariable String idPersona, @RequestParam(defaultValue = "simple") String type){
        try{
            if (type.equals("simple")){
                PersonaOutputDTO personaOutputDTO = personaService.getUserByID(idPersona);
                return new ResponseEntity<>(personaOutputDTO,HttpStatus.OK);
            }
            else if (type.equals("full")){
                return new ResponseEntity<>(studentService.getStudentPersona(idPersona), HttpStatus.OK);
            }
            else {
                return null;
            }
        }catch (Exception e){
            return new ResponseEntity<>("Usuario no existe", HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping("/user/username/{username}")
    public ResponseEntity<Object> getPersonaByUsername(@PathVariable String username, @RequestParam(defaultValue = "simple") String type){
        try{
            if (type.equals("simple")){
                PersonaOutputDTO personaOutputDTO = personaService.findByUsername(username);
                return new ResponseEntity<>(personaOutputDTO,HttpStatus.OK);
            }
            else if (type.equals("full")){
                return new ResponseEntity<>(studentService.getStudentPersona(username), HttpStatus.OK);
            }
            else {
                return null;
            }
        }catch (Exception e){
            return new ResponseEntity<>("Usuario no existe", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/roles")
    public List<Roles> getRoles(){
        return personaService.getRoles();
    }
}

