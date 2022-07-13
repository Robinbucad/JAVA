package com.example.InyeccionDependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController

public class Controlador1{

    @Autowired
    PersonaInt personaInt;

    @GetMapping("/ping")
    public String getPong(){
        return "Pong";
    }


    @GetMapping("/controlador1/addPersona")
    PersonaInt addPersona(@RequestHeader Map<String , String> personaValues){
       personaInt.setNombre(personaValues.get("nombre"));
       personaInt.setPoblacion(personaValues.get("poblacion"));
       personaInt.setEdad(personaValues.get("edad"));

       return personaInt;
    }

    /* MANERA LARGA sin MAP
    @GetMapping("/controlador1/addPersona")
    PersonaInt addPersona(@RequestHeader("nombre") String nombre, @RequestHeader("poblacion") String poblacion, @RequestHeader("edad") String edad){
        personaInt.setNombre(nombre);
        personaInt.setPoblacion(poblacion);
        personaInt.setEdad(edad);

        return personaInt;
    }*/



}
