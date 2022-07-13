package com.example.InyeccionDependencias;


import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Data
public class Persona{

 private String nombre;
 private String poblacion;
 private String edad;

}
