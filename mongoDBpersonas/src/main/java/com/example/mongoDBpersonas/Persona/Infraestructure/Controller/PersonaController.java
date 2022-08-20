package com.example.mongoDBpersonas.Persona.Infraestructure.Controller;


import com.example.mongoDBpersonas.Persona.Application.PersonaService;
import com.example.mongoDBpersonas.Persona.Infraestructure.Controller.Input.PersonaInputDTO;
import com.example.mongoDBpersonas.Persona.Infraestructure.Controller.Output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/persona")
    public List<PersonaOutputDTO> getAllPersonas(){
        return personaService.getAllPersonas();
    }

    @PostMapping("/persona")
    public ResponseEntity<Object> createPersona(@RequestBody PersonaInputDTO personaInputDTO){
        try {
            return new ResponseEntity<>(personaService.createPersona(personaInputDTO), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error al crear persona", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/persona/{idPersona}")
    public ResponseEntity<Object> getPersonaById(@PathVariable int idPersona){
        try {
            return new ResponseEntity<>(personaService.getPersonaById(idPersona), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Persona no existe", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/persona/{idPersona}")
    public ResponseEntity<String> deletePersona(@PathVariable int idPersona){
        try {
            return new ResponseEntity<>(personaService.deletePersona(idPersona), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Persona no existe", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/persona/{idPersona}")
    public ResponseEntity<Object> updatePersona(@PathVariable int idPersona, @RequestBody PersonaInputDTO personaInputDTO){
        try {
            return new ResponseEntity<>(personaService.updatePersona(personaInputDTO,idPersona),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al actualizar persona", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
