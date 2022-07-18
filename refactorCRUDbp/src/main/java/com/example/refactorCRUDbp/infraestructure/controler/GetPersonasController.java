package com.example.refactorCRUDbp.infraestructure.controler;


import com.example.refactorCRUDbp.application.PersonaService;
import com.example.refactorCRUDbp.domain.Persona;
import com.example.refactorCRUDbp.infraestructure.controler.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetPersonasController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/pong")
    public String getPing(){
        return "Ping";
    }


    @GetMapping("/user/id/{idPersona}")
    public PersonaOutputDTO getUserByID(@PathVariable int idPersona)throws Exception{
        return personaService.getUserByID(idPersona);
    }

    @GetMapping("/user/username/{username}")
    public PersonaOutputDTO getPersonaByUsername(@PathVariable String username) throws Exception{
        return personaService.findByUsername(username);
    }

}
