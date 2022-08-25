package com.jdbcTemplate.persona.controller.repository;

import com.jdbcTemplate.persona.application.IPersonaDAS;
import com.jdbcTemplate.persona.rowMapper.PersonasRowMapper;
import com.jdbcTemplate.persona.controller.dto.PersonaRecord;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonaDataAccessService implements IPersonaDAS {


    private final JdbcTemplate jdbcTemplate;

    public PersonaDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public List<PersonaRecord> getAllPersonas(){
        String sql= """
                SELECT *
                FROM personas
                LIMIT 100
                """;
        List<PersonaRecord> personasList = jdbcTemplate.query(sql,new PersonasRowMapper());
        return personasList;
    }

    @Override
    public int insertPersona(PersonaRecord personaRecord){
        String sql = """
                INSERT INTO personas(
                name,
                password,
                surname,
                username,
                city,
                company_email,
                personal_email,
                active,
                url_image,
                creation_date,
                termination_date
                )
                VALUES (?,?,?,?,?,?,?,?,?,?,?)
                """;
        return jdbcTemplate.update(
                sql,
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

    @Override
    public Optional<PersonaRecord> getPersonaById(int id){
        String sql = """
                SELECT id_persona,
                name,
                password,
                surname,
                username,
                city,
                company_email,
                personal_email,
                active,
                url_image,
                creation_date,
                termination_date
                FROM personas 
                WHERE id_persona = ? 
                """;
        return jdbcTemplate.query(sql,new PersonasRowMapper(),id)
                .stream()
                .findFirst();
    }

    public int deletePersona(int id){
        String sql = """
                DELETE FROM personas 
                WHERE id_persona = ?
                """;
        return jdbcTemplate.update(sql,id);
    }

    public PersonaRecord updatePersona(PersonaRecord personaRecord, int id){
        String sql = """
                UPDATE personas
                SET name = ?,
                password = ?,
                surname = ?,
                username = ?,
                city = ?,
                company_email = ?,
                personal_email = ?,
                active = ?,
                url_image = ?,
                creation_date = ?,
                termination_date = ? WHERE id_persona = ?
                """;
        jdbcTemplate.update(
                sql,
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
