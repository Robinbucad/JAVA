package com.example.relacionTablas.Persona.infraestrucure.controller;


import com.example.relacionTablas.Persona.application.PersonaService;
import com.example.relacionTablas.Persona.infraestrucure.controller.input.PersonaInputDto;
import com.example.relacionTablas.Persona.infraestrucure.controller.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PutPersonaController {

    @Autowired
    PersonaService personaService;

    @PutMapping("/persona/{idPersona}")
    public ResponseEntity<Object> updatePersona(@PathVariable String idPersona, @RequestBody PersonaInputDto personaInputDto){

        try {

            PersonaOutputDto personaUpdated = personaService.updatePersona(idPersona,personaInputDto);
            return new ResponseEntity<>(personaUpdated, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>("Error al actualizar persona", HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

}
