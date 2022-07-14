package com.example.InyeccionDependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController

public class Controlador1{

    @Autowired
    PersonaInt personaInt;

    @Autowired
    CiudadInt ciudadInt;

    @Autowired
    @Qualifier("persona1")
    PersonaInt persona1;

    @Autowired
    @Qualifier("persona2")
    PersonaInt persona2;

    @Autowired
    @Qualifier("persona3")
    PersonaInt persona3;

    @Autowired
    @Qualifier("notFound")
    PersonaInt notFound;



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

    @PostMapping("controlador1/addCiudad")
    CiudadInt addCiudad(@RequestBody Ciudad ciudad){ // Envio por el body la ciudad
        ciudadInt.addCiudad(ciudad);
        return ciudadInt;
    }
    @GetMapping("/controlador/bean/{bean}")
    PersonaInt getPersona1(@PathVariable String bean){
        switch (bean){
            case "bean1": return persona1;
            case "bean2": return persona2;
            case "bean3": return persona3;
            default: return notFound;
        }

    }


}
