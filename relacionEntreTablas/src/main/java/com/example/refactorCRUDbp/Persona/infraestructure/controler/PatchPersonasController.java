package com.example.refactorCRUDbp.Persona.infraestructure.controler;

import com.example.refactorCRUDbp.Persona.application.PersonaService;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.input.PersonaInputDTO;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatchPersonasController {

    @Autowired
    PersonaService personaService;

    @PatchMapping("/user/id/{idPersona}")
    public PersonaOutputDTO updateUser(@RequestBody PersonaInputDTO personaInputDTO, @PathVariable String idPersona){
            return personaService.updateUsername(personaInputDTO, idPersona);
    }

}
