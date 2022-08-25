package com.jdbcTemplate.persona.controller;

import com.jdbcTemplate.persona.application.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeletePersonaController {

    @Autowired
    PersonaService personaService;

    @DeleteMapping("/personas/{id}")
    public String deletePersona(@PathVariable int id){
        return personaService.deletePersona(id);
    }

}
