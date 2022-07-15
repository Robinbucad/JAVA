package com.example.CRUD;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                .filter(p-> name.equalsIgnoreCase(p.getName())).findFirst().orElse(null);
        return persona;
    }

    public Persona updatePersonaById(Persona persona, String id){
        Persona personaById = getPersonaById(id);
        if(persona.getName() != null){
            personaById.setName(persona.getName());
        }
        if (persona.getLocation() != null){
            personaById.setLocation(persona.getLocation());
        }
        if (persona.getAge() != null){
            personaById.setAge(persona.getAge());
        }
        if (persona.getId() != null){
            personaById.setId(persona.getId());
        }


        return personaById;
    }

    public Persona deletePersonaById(String id){
        Persona deletedPersona = getPersonaById(id);
        personaList.remove(deletedPersona);
        return deletedPersona;
    }
    public void addPersona(Persona persona){
        personaList.add(persona);
    }

}
