package com.jdbcTemplate.persona.controller;

import com.jdbcTemplate.persona.application.PersonaService;
import com.jdbcTemplate.persona.controller.dto.PersonaRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GetPersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/personas")
    public List<PersonaRecord> getAllPersonas(){
        return personaService.getAllPersonas();
    }

    @GetMapping("/personas/{id}")
    public Optional<PersonaRecord> getPErsonaById(@PathVariable int id){
        return personaService.getPersonaById(id);
    }



}
