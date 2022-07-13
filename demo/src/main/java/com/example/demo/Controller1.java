package com.example.demo;


import org.springframework.web.bind.annotation.*;

@RestController
public class Controller1 {

    @GetMapping("/hola/{name}")
    public String getHolaName(@PathVariable String name){
        return "Hola " + name;
    }

    @PostMapping("/useradd")
    public String postPersona(@RequestBody Persona persona){ // Vamos a enviar la persona por el body
        return persona.salidaPost();
    }

}
