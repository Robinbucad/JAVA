package com.example.refactorCRUDbp.infraestructure.controler;

import com.example.refactorCRUDbp.application.PersonaService;
import com.example.refactorCRUDbp.infraestructure.controler.input.PersonaInputDTO;
import com.example.refactorCRUDbp.infraestructure.controler.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatchPersonasController {

    @Autowired
    PersonaService personaService;

    @PatchMapping("/user/id/{idPersona}")
    public ResponseEntity<String> updateUser(@RequestBody PersonaInputDTO personaInputDTO, @PathVariable int idPersona){

        try {
            personaService.updateUsername(personaInputDTO, idPersona);
            return new ResponseEntity<>("Nombre usuario actualizado correctamente. Nuevo nombre: " + personaInputDTO.getUsername(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al modificar, el usuario debe tener entre 6 y 10 caracteres.", HttpStatus.UNPROCESSABLE_ENTITY);
        }


    }

}
