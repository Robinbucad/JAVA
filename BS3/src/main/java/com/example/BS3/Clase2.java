package com.example.BS3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Clase2 implements CommandLineRunner {
    public void run(String... args) throws Exception{
        System.out.println("Hola desde la clase secundaria");
    }
}
