package com.jdbcTemplate.persona.controller;

import com.jdbcTemplate.persona.application.PersonaService;
import com.jdbcTemplate.persona.controller.dto.PersonaRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PutPersonaController {

    @Autowired
    PersonaService personaService;

    @PutMapping("/personas/{id}")
    public PersonaRecord updatePersona(@RequestBody PersonaRecord personaRecord, @PathVariable int id){
        return personaService.updatePersona(personaRecord, id);
    }

}
