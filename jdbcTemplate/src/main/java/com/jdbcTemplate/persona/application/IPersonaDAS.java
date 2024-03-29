package com.jdbcTemplate.persona.application;

import com.jdbcTemplate.exception.NotFoundException;
import com.jdbcTemplate.persona.controller.dto.PersonaRecord;

import java.util.List;
import java.util.Optional;

public interface IPersonaDAS {

    List<PersonaRecord> getAllPersonas();
    int addNewPersona(PersonaRecord personaRecord);

    Optional<PersonaRecord> getPersonaById(int id);

    String deletePersona(int id);

    PersonaRecord updatePersona(PersonaRecord personaRecord, int id);

}
