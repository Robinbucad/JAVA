package com.example.InyeccionDependencias;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CiudadImpl implements CiudadInt{

    List<Ciudad> ciudadList = new ArrayList<>(); // Creo array de ciudades para hacer futuro push

    public List<Ciudad> getCiudadList(){
        return ciudadList;
    }

    public void addCiudad(Ciudad ciudad){
      ciudadList.add(ciudad);
    } // Funcion que hace push al array de ciudades


}
