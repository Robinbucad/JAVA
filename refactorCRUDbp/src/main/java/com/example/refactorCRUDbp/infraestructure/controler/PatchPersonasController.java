package com.example.refactorCRUDbp.infraestructure.controler;

import com.example.refactorCRUDbp.application.PersonaService;
import com.example.refactorCRUDbp.infraestructure.controler.input.PersonaInputDTO;
import com.example.refactorCRUDbp.infraestructure.controler.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatchPersonasController {

    @Autowired
    PersonaService personaService;

    @PatchMapping("/user/id/{idPersona}")
    public PersonaOutputDTO updateUser(@RequestBody PersonaInputDTO personaInputDTO,@PathVariable int idPersona) throws Exception{
        return personaService.updateUsername(personaInputDTO, idPersona);
    }

}
