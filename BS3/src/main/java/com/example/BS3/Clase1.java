package com.example.BS3;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Clase1 {
    @PostConstruct
    public void claseInicial(){
        System.out.println("Hola soy la clase inicial");
    }
}
