package com.example.relacionTablas.Persona.infraestrucure.controller;


import com.example.relacionTablas.Persona.application.PersonaService;
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

    @DeleteMapping("/persona/{idPersona}")
    public ResponseEntity<Object> deletePersona(@PathVariable String idPersona){
        try {
            return new ResponseEntity<>(personaService.deletePersona(idPersona), HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>("Error al eliminar persona", HttpStatus.NOT_FOUND);
        }
    }

}
