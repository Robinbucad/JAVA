package com.example.refactorCRUDbp.Persona.infraestructure.controler.output;


import com.example.refactorCRUDbp.Persona.domain.Persona;
import lombok.Data;

import java.util.Date;

@Data
public class PersonaOutputDTO {

    private int idPersona;
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

    public PersonaOutputDTO(Persona persona){
        setIdPersona(persona.getIdPersona());
        setUsername(persona.getUsername());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getPersonal_email());
        setCity(persona.getCity());
        setActive(persona.isActive());
        setCreated_date(persona.getCreated_date());
        setImage_url(persona.getImage_url());
        setTermination_date(persona.getTermination_date());
    }

    public PersonaOutputDTO(){

    }

}
