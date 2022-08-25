package com.jdbcTemplate.persona.application;

import com.jdbcTemplate.persona.controller.dto.PersonaRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    IPersonaDAS iPersonaDAS;


    public List<PersonaRecord> getAllPersonas(){
        return iPersonaDAS.getAllPersonas();
    }

    public void addNewPersona(PersonaRecord personaRecord){
        iPersonaDAS.insertPersona(personaRecord);
    }

    public Optional<PersonaRecord> getPersonaById(int id){
        return iPersonaDAS.getPersonaById(id);
    }

    public String deletePersona(int id){
        iPersonaDAS.deletePersona(id);
        return "Persona con id "+id + " borrada correctamente";
    }

    public PersonaRecord updatePersona(PersonaRecord personaRecord, int id){
        return iPersonaDAS.updatePersona(personaRecord,id);
    }

}
