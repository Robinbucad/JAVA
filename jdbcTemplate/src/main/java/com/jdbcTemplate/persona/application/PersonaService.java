package com.jdbcTemplate.persona.application;

import com.jdbcTemplate.exception.NotFoundException;
import com.jdbcTemplate.persona.controller.dto.PersonaRecord;
import com.jdbcTemplate.persona.controller.repository.PersonaDataAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaDAS{


    @Autowired
    PersonaDataAccessService personaDAS;


    public List<PersonaRecord> getAllPersonas(){
        return personaDAS.getAllPersonas();
    }

    public int addNewPersona(PersonaRecord personaRecord){
       return personaDAS.insertPersona(personaRecord);
    }

    public Optional<PersonaRecord> getPersonaById(int id){
            return Optional.ofNullable(personaDAS.getPersonaById(id).orElseThrow(() -> new NotFoundException("Not found")));
    }

    public String deletePersona(int id){
        Optional<PersonaRecord> personas = personaDAS.getPersonaById(id);
        if (personas.isEmpty()){
            throw new NotFoundException("Not found");
        }else {
            personaDAS.deletePersona(id);
            return "Persona con id "+id + " borrada correctamente";
        }
    }

    public PersonaRecord updatePersona(PersonaRecord personaRecord, int id){
        Optional<PersonaRecord> personas = personaDAS.getPersonaById(id);
        if (personas.isEmpty()){
            throw new NotFoundException("Not found");
        }else {
            return personaDAS.updatePersona(personaRecord,id);
        }
    }

}
