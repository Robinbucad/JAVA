package com.example.CRUDvalidation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaControler {

    @Autowired
    PersonaService personaService;

   @GetMapping
    public String getPing(){
       return "pong";
   }

   @GetMapping("/users")
    public List<PersonaEntity> findAll(){
       return personaService.findAll();
   }

   @PostMapping("/users")
    public PersonaOutputDTO addUser(@RequestBody PersonaInputDTO personaInputDTO)throws Exception{
       return personaService.addUser(personaInputDTO);
   }

    @GetMapping("/users/{usuario}")
    public PersonaOutputDTO findByUsername(@PathVariable String usuario) throws Exception{
       return personaService.findByUsername(usuario);
    }

    @GetMapping("/users/id/{idPersona}")
    public PersonaOutputDTO findByID(@PathVariable int idPersona)throws Exception{
       return personaService.findByIdPersona(idPersona);
    }

}
