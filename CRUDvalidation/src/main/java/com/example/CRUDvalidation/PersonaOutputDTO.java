package com.example.CRUDvalidation;

import java.util.Date;

public record PersonaOutputDTO(
        String usuario,
        String name,
        String password,
        String surname,
        String company_email,
        String personal_email,
        String city,
        boolean active,
        String imagen_url,
        Date creation_date,
        Date termination_date
) {

    public PersonaOutputDTO(PersonaEntity persona){
        this(
                persona.getUsername(),
                persona.getName(),
                persona.getPassword(),
                persona.getSurname(),
                persona.getPersonal_email(),
                persona.getCompany_email(),
                persona.getCity(),
                persona.isActive(),
                persona.getUrl_image(),
                persona.getCreation_date(),
                persona.getTermination_date()
        );
    }

}
