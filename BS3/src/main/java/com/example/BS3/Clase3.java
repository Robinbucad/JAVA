package com.example.BS3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class Clase3 implements CommandLineRunner {
    public void run(String... args) throws Exception{
        System.out.println("Hola desde la clase 3");
    }
    /*
    * EJEMPLO:
    *
    * CommandLineRUnner ejecutame(){
    *   return p->  {
    *       System.out.println("Linea a ejecutar cuando arranque")
    *   }
    * }
    *
    * */


    @Bean
    CommandLineRunner ejecutame(Customer c){
        return  p -> {
            System.out.println("Mi nombre es " + c.getNombre() + " y soy de " + c.getPoblacion());
        };
    }
}
