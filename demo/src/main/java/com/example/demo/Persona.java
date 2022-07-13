package com.example.demo;

public class Persona {

    private String nombre;
    private String poblacion;
    private String edad;


    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getPoblacion(){
        return poblacion;
    }

    public void setPoblacion(String poblacion){
        this.poblacion = poblacion;
    }

    public String getEdad(String edad){
        return edad;
    }

    public void setEdad(String edad){
        this.edad = edad;
    }


    public String salidaPost(){
        return "nombre:" + nombre + " poblacion:" + poblacion + " edad:" + edad ;
    }
}
