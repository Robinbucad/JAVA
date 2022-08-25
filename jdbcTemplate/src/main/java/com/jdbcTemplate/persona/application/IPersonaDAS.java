package com.jdbcTemplate.persona.application;

import com.jdbcTemplate.persona.controller.dto.PersonaRecord;

import java.util.List;
import java.util.Optional;

public interface IPersonaDAS {

    List<PersonaRecord> getAllPersonas();
    int insertPersona(PersonaRecord personaRecord);

    Optional<PersonaRecord> getPersonaById(int id);

    int deletePersona(int id);

    PersonaRecord updatePersona(PersonaRecord personaRecord, int id);

}
