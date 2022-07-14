package com.example.CRUD;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImpPersona implements IPersona{

    List<Persona> personaList = new ArrayList<>();

    public List<Persona> getListPersonas(){
        return personaList;
    }

    public Persona getPersonaById(String id){
        Persona persona = personaList.stream()
                .filter(p-> id.equals(p.getId())).findFirst().orElse(null);
            return persona;
    }

    public Persona getPersonaByName(String name){
        Persona persona = personaList.stream()
                .filter(p-> name.equals(p.getName())).findFirst().orElse(null);
        return persona;
    }
    public void addPersona(Persona persona){
        personaList.add(persona);
    }

}
