package com.example.refactorCRUDbp.infraestructure.controler;

import com.example.refactorCRUDbp.application.PersonaService;
import com.example.refactorCRUDbp.infraestructure.controler.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DeletePersonaController {

    @Autowired
    PersonaService personaService;

    @DeleteMapping("/user/id/{idPersona}")
    public PersonaOutputDTO deleteUser(@PathVariable int idPersona)throws Exception{
        return personaService.deleteUser(idPersona);
    }

}
