package com.example.refactorCRUDbp.infraestructure.controler;

import com.example.refactorCRUDbp.application.PersonaService;
import com.example.refactorCRUDbp.infraestructure.controler.input.PersonaInputDTO;
import com.example.refactorCRUDbp.infraestructure.controler.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostPersonaController {

    @Autowired
    PersonaService personaService;

    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@RequestBody PersonaInputDTO personaInputDTO) throws Exception{
        try {
            PersonaOutputDTO personaOutputDTOPost = personaService.createUser(personaInputDTO);
            return new ResponseEntity<>(personaOutputDTOPost, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("El nombre de usuario debe tener entre 6 y 10 caracteres.", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
