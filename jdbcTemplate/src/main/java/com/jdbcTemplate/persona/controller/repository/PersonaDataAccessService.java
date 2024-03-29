package com.jdbcTemplate.persona.controller.repository;

import com.jdbcTemplate.persona.application.IPersonaDAS;
import com.jdbcTemplate.persona.rowMapper.PersonasRowMapper;
import com.jdbcTemplate.persona.controller.dto.PersonaRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonaDataAccessService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String GET_PERSONAS_QUERY = "SELECT * FROM personas";
    private final String INSERT_PERSONAS_QUERY = "INSERT INTO personas(name,password,surname,username,city,company_email,personal_email,active,url_image,creation_date,termination_date)VALUES (?,?,?,?,?,?,?,?,?,?,?)";

    private final String GET_PERSONABYID_QUERY = " SELECT * FROM personas WHERE id_persona = ?";
    private final String DELETE_PERSONA_QUERY = "DELETE FROM personas  WHERE id_persona = ?";
    private final String UPDATE_PERSONA_QUERY= "UPDATE personas SET name = ?,password = ?,surname = ?,username = ?,city = ?,company_email = ?,personal_email = ?,active = ?,url_image = ?,creation_date = ?,termination_date = ? WHERE id_persona = ?";


    public List<PersonaRecord> getAllPersonas(){
        List<PersonaRecord> personasList = jdbcTemplate.query(GET_PERSONAS_QUERY,new PersonasRowMapper());
        return personasList;
    }


    public int insertPersona(PersonaRecord personaRecord){
        return jdbcTemplate.update(
                INSERT_PERSONAS_QUERY,
                personaRecord.name(),
                personaRecord.password(),
                personaRecord.surname(),
                personaRecord.username(),
                personaRecord.city(),
                personaRecord.company_email(),
                personaRecord.personal_email(),
                personaRecord.active(),
                personaRecord.url_image(),
                personaRecord.creation_date(),
                personaRecord.termination_date()
        );
    }


    public Optional<PersonaRecord> getPersonaById(int id){
        return jdbcTemplate.query(GET_PERSONABYID_QUERY,new PersonasRowMapper(),id)
                .stream()
                .findFirst();
    }

    public int deletePersona(int id){
        return jdbcTemplate.update(DELETE_PERSONA_QUERY,id);
    }

    public PersonaRecord updatePersona(PersonaRecord personaRecord, int id){

        jdbcTemplate.update(
                UPDATE_PERSONA_QUERY,
                personaRecord.name(),
                personaRecord.password(),
                personaRecord.surname(),
                personaRecord.username(),
                personaRecord.city(),
                personaRecord.company_email(),
                personaRecord.personal_email(),
                personaRecord.active(),
                personaRecord.url_image(),
                personaRecord.creation_date(),
                personaRecord.termination_date(),
                id
        );
        return personaRecord;
    }
}
