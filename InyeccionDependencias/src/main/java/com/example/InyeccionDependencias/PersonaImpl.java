package com.example.InyeccionDependencias;

import org.springframework.stereotype.Service;

@Service
public class PersonaImpl implements PersonaInt{
    Persona persona = new Persona();

    public String getNombre(){
        return persona.getNombre();
    }

    public String getPoblacion(){
        return persona.getPoblacion();
    }

    public String getEdad(){
        return persona.getEdad();
    }

    public void setNombre(String nombre){
        persona.setNombre(nombre);
    }

    public void setPoblacion(String poblacion){
        persona.setPoblacion(poblacion);
    }

    public void setEdad(String edad){
        persona.setEdad(edad);
    }

}
