package com.example.InyeccionDependencias;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador2 {

    @Autowired
    PersonaInt personaInt;

    @Autowired
    CiudadInt ciudadInt;

    @GetMapping("/pong")
    public String getPing(){
        return "ping";
    }
    @GetMapping("/controlador2/getPersona")
    PersonaInt getEdad2(){
        System.out.println(Integer.parseInt(personaInt.getEdad()) * 2);
        return personaInt;
    }

    @GetMapping("/controlador1/getCiudad")
    CiudadInt getCiudadList(){
        return ciudadInt;
    }



}
