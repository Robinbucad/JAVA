package com.example.CRUD;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class Controller {

    @Autowired
    IPersona ipersona;

    @PostMapping
    IPersona postPersona(@RequestBody Persona persona){
        ipersona.addPersona(persona);
        return ipersona;
    }

    @GetMapping
    IPersona getListaPersonas(){
        return ipersona;
    }

    @GetMapping("/{id}")
    Persona getPersonaById(@PathVariable String id){
        return ipersona.getPersonaById(id);
    }

    @DeleteMapping("/{id}")
    Persona deletePersonaById(@PathVariable String id){
        return ipersona.deletePersonaById(id);
    }

    @GetMapping("/nombre/{name}")
    Persona getPersonaByName(@PathVariable String name){
        return ipersona.getPersonaByName(name);
    }

    @PutMapping("/{id}")
    Persona updatePersonaById(@RequestBody Persona persona, @PathVariable String id){
        return ipersona.updatePersonaById(persona,id);
    }


}
