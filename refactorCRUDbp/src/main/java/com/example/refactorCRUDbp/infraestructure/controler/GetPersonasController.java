package com.example.refactorCRUDbp.infraestructure.controler;


import com.example.refactorCRUDbp.application.PersonaService;
import com.example.refactorCRUDbp.domain.Persona;
import com.example.refactorCRUDbp.infraestructure.controler.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetPersonasController {

    @Autowired
    PersonaService personaService;

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
    public ResponseEntity<Object> getUserByID(@PathVariable int idPersona){
        try {
            PersonaOutputDTO personaOutputDTO = personaService.getUserByID(idPersona);
            return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("No se ha encontrado", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/user/username/{username}")
    public ResponseEntity<Object> getPersonaByUsername(@PathVariable String username){
        try{
            PersonaOutputDTO personaOutputDTO = personaService.findByUsername(username);
            return new ResponseEntity<>(personaOutputDTO,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Usuario no existe", HttpStatus.NOT_FOUND);
        }

    }

}
