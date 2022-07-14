package com.example.CRUD;

import java.util.List;

public interface IPersona {

    void addPersona(Persona persona);

    Persona getPersonaById(String id);
    Persona getPersonaByName(String name);

    Persona deletePersonaById(String id);
    Persona updatePersonaById(Persona persona, String id);
    List<Persona> getListPersonas();

}
