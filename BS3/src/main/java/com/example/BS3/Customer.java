package com.example.BS3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Customer {
    private String nombre = "robin";
    private String poblacion = "alicante";

    // Setters y getters

    @Bean
    String getNombre(){
        return nombre;
    }
    @Bean
    String getPoblacion(){
        return poblacion;
    }

}
