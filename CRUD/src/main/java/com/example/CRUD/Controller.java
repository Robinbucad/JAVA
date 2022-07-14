package com.example.CRUD;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    IPersona ipersona;

    @RequestMapping(value = "/persona", method = RequestMethod.POST)
    IPersona postPersona(@RequestBody Persona persona){
        ipersona.addPersona(persona);
        return ipersona;
    }

    @RequestMapping(value = "/persona", method = RequestMethod.GET)
    IPersona getListaPersonas(){
        return ipersona;
    }

    @RequestMapping(value = "/persona/{id}", method = RequestMethod.GET)
    Persona getPersonaById(@PathVariable String id){
        return ipersona.getPersonaById(id);
    }

    @RequestMapping(value = "/persona/{id}", method = RequestMethod.DELETE)
    Persona deletePersonaById(@PathVariable String id){
        return ipersona.deletePersonaById(id);
    }

    @RequestMapping(value = "/persona/nombre/{name}", method = RequestMethod.GET)
    Persona getPersonaByName(@PathVariable String name){
        return ipersona.getPersonaByName(name);
    }

    @RequestMapping(value = "/persona/{id}", method = RequestMethod.PUT)
    Persona updatePersonaById(@RequestBody Persona persona, @PathVariable String id){
        return ipersona.updatePersonaById(persona,id);
    }


}
