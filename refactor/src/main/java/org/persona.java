package org;
import java.util.*;

public class persona {

    private String nombre;
    private String poblacion;
    private String edad;

    public Optional<String> getName(){
        return Optional.ofNullable(nombre);
    }

    public void setName(String nombre){
        this.nombre = nombre;
    }

    public Optional<String> getPoblacion(){
        return Optional.ofNullable(poblacion);
    }

    public void setPoblacion(String poblacion){
        this.poblacion = poblacion;
    }

    public Optional<String> getEdad(){
        return Optional.ofNullable(edad);
    }

    public void setEdad(String edad){
        this.edad = edad;
    }


}
