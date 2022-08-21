package com.example.CRUDvalidation;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Personas")
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idPersona;

    private String username;

    private String name;

    private String password;

    private String surname;

    private String company_email;

    private String personal_email;

    private String city;

    private boolean active;

    private String url_image;

    private Date creation_date;

    private Date termination_date;


    public PersonaEntity(PersonaInputDTO persona){

        setUsername(persona.username());
        setName(persona.name());
        setPassword(persona.password());
        setSurname(persona.surname());
        setCompany_email(persona.company_email());
        setPersonal_email(persona.personal_email());
        setCity(persona.city());
        setActive(persona.active());
        setUrl_image(persona.url_image());
        setCreation_date(persona.creation_date());
        setTermination_date(persona.termination_date());
    }

    public void updatePersona(PersonaInputDTO persona){
        setUsername(persona.username());
        setName(persona.name());
        setPassword(persona.password());
        setSurname(persona.surname());
        setCompany_email(persona.company_email());
        setPersonal_email(persona.personal_email());
        setCity(persona.city());
        setActive(persona.active());
        setUrl_image(persona.url_image());
        setCreation_date(persona.creation_date());
        setTermination_date(persona.termination_date());
    }
    public PersonaEntity(){

    }

}
