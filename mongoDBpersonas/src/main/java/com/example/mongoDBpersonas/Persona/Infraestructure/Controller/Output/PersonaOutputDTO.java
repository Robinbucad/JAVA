package com.example.mongoDBpersonas.Persona.Infraestructure.Controller.Output;

import com.example.mongoDBpersonas.Persona.Domain.PersonaEntity;

import java.util.Date;

public record PersonaOutputDTO(
        int idPersona,
        String username,
        String name,
        String password,
        String surname,
        String company_email,
        String personal_email,
        String city,
        boolean active,
        String image_url,
        Date creation_date,
        Date termination_date
) {

    public PersonaOutputDTO(PersonaEntity persona){
        this(
            persona.getIdPersona(),
            persona.getUsername(),
            persona.getName(),
            persona.getPassword(),
            persona.getSurname(),
            persona.getCompany_email(),
            persona.getPersonal_email(),
            persona.getCity(),
            persona.isActive(),
            persona.getImage_url(),
            persona.getCreation_date(),
            persona.getTermination_date()
        );
    }

}
