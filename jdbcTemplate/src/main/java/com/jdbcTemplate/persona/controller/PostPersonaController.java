package com.jdbcTemplate.persona.controller;

import com.jdbcTemplate.persona.application.PersonaService;
import com.jdbcTemplate.persona.controller.dto.PersonaRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostPersonaController {

    @Autowired
    PersonaService personaService;

    @PostMapping("/personas")
    public void addPersona(@RequestBody PersonaRecord personaRecord){
        System.out.println(personaRecord);
        personaService.addNewPersona(personaRecord);
    }


}
