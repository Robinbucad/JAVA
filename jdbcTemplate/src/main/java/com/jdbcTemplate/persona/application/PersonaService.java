package com.jdbcTemplate.persona.application;

import com.jdbcTemplate.persona.controller.dto.PersonaRecord;
import com.jdbcTemplate.persona.controller.repository.PersonaDataAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {


    @Autowired
    PersonaDataAccessService personaDAS;


    public List<PersonaRecord> getAllPersonas(){
        return personaDAS.getAllPersonas();
    }

    public void addNewPersona(PersonaRecord personaRecord){
        personaDAS.insertPersona(personaRecord);
    }

    public Optional<PersonaRecord> getPersonaById(int id){
        return personaDAS.getPersonaById(id);
    }

    public String deletePersona(int id){
        personaDAS.deletePersona(id);
        return "Persona con id "+id + " borrada correctamente";
    }

    public PersonaRecord updatePersona(PersonaRecord personaRecord, int id){
        return personaDAS.updatePersona(personaRecord,id);
    }

}
