package com.jdbcTemplate.persona.rowMapper;

import com.jdbcTemplate.persona.controller.dto.PersonaRecord;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class PersonasRowMapper implements RowMapper<PersonaRecord> {
    @Override
    public PersonaRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PersonaRecord(
                rs.getInt("id_persona"),
                rs.getString("name"),
                rs.getString("password"),
                rs.getString("surname"),
                rs.getString("username"),
                rs.getString("city"),
                rs.getString("company_email"),
                rs.getString("personal_email"),
                rs.getBoolean("active"),
                rs.getString("url_image"),
                LocalDate.parse(rs.getString("creation_date")),
                LocalDate.parse(rs.getString("termination_date")));
    }
}
