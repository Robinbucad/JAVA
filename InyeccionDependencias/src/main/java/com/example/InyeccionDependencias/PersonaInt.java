package com.example.InyeccionDependencias;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface PersonaInt {

    String getNombre();
    String getPoblacion();
    String getEdad();
    void setNombre(String nombre);
    void setPoblacion(String poblacion);
    void setEdad(String edad);

}
