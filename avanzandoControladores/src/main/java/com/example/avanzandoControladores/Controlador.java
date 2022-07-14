package com.example.avanzandoControladores;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {

    @GetMapping("/ping")
    public String getPong(){
        return "pong";
    }

}
