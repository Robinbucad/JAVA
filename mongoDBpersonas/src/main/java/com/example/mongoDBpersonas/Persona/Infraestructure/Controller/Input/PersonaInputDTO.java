package com.example.mongoDBpersonas.Persona.Infraestructure.Controller.Input;

import lombok.Data;

import java.util.Date;

public record PersonaInputDTO(
        int idPersona,
        String username,
        String password,
        String name,
        String surname,
        String company_email,
        String personal_email,
        String city,
        boolean active,
        Date creation_date,
        Date termination_date,
        String image_url
) {

}
