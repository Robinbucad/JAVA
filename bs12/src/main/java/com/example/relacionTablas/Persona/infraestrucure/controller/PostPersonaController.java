package com.example.relacionTablas.Persona.infraestrucure.controller;

import com.example.relacionTablas.Persona.application.PersonaService;
import com.example.relacionTablas.Persona.infraestrucure.controller.input.PersonaInputDto;
import com.example.relacionTablas.Persona.infraestrucure.controller.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = RequestMethod.POST)
public class PostPersonaController {

    @Autowired
    PersonaService personaService;

    @PostMapping("/persona")
    public ResponseEntity<Object> createPersona(@RequestBody PersonaInputDto personaInputDto){
        try {
            PersonaOutputDto personaOutputDto = personaService.createPersona(personaInputDto);
            return new ResponseEntity<>(personaOutputDto, HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(personaInputDto);
            return new ResponseEntity<>("Error al crear la persona", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
