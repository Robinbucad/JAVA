package com.example.refactorCRUDbp.Persona.infraestructure.controler.input;


import com.example.refactorCRUDbp.Persona.domain.Roles;
import lombok.Data;

import java.util.Collection;
import java.util.Date;

@Data
public class PersonaInputDTO {

    private String idPersona;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String image_url;
    private Date termination_date;
    private Collection<Roles> roles;


    public PersonaInputDTO(
            String username,
            String password,
            String name,
            String surname,
            String company_email,
            String personal_email,
            String city,
            boolean active,
            Date created_date,
            Date termination_date,
            String image_url,
            Collection<Roles> roles
    ){
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.company_email = company_email;
        this.personal_email = personal_email;
        this.city = city;
        this.active = active;
        this.created_date = created_date;
        this.termination_date = termination_date;
        this.image_url = image_url;
        this.roles = roles;

    }

}
