package com.example.refactorCRUDbp.Persona.infraestructure.controler;

import com.example.refactorCRUDbp.Persona.application.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeletePersonaController {

    @Autowired
    PersonaService personaService;

    @DeleteMapping("/user/id/{idPersona}")
    public ResponseEntity<Object> deleteUser(@PathVariable int idPersona){
        try {
            personaService.deleteUser(idPersona);
            return new ResponseEntity<>("Borrada correctamente", HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>("No existe ususario", HttpStatus.NOT_FOUND);
        }

    }

}
