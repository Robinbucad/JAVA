package com.example.refactorCRUDbp.Persona.infraestructure.controler;

import com.example.refactorCRUDbp.Persona.application.PersonaService;
import com.example.refactorCRUDbp.Persona.domain.Roles;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.input.PersonaInputDTO;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.output.PersonaOutputDTO;
import lombok.Data;
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
    public PersonaOutputDTO createUser(@RequestBody PersonaInputDTO personaInputDTO){
        return personaService.createUser(personaInputDTO);
    }

    @PostMapping("/user/addrole")
    public ResponseEntity<Object> createRole(@RequestBody Roles roles){
        personaService.saveRole(roles);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/addroletouser")
    public ResponseEntity<Object> addRoleToUser(@RequestBody RoleToUserForm role){
        personaService.addRoleToUser(role.getUsername(), role.getRolename());
        return ResponseEntity.ok().build();
    }
}

@Data
class RoleToUserForm{
    private String username;
    private String rolename;
}