package com.jdbcTemplate.persona.controller.dto;

import java.time.LocalDate;

public record PersonaRecord(
        Integer id_persona,
        String name,
        String password,
        String surname,
        String username,
        String city,
        String company_email,
        String personal_email,
        boolean active,
        String url_image,
        LocalDate creation_date,
        LocalDate termination_date
) {

}
