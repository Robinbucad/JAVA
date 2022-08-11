package com.example.CRUDvalidation;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Personas")
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    public PersonaEntity(PersonaInputDTO persona){

        setUsername(persona.getUsername());
        setName(persona.getName());
        setPassword(persona.getPassword());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getCompany_email());
        setCity(persona.getCity());
        setActive(persona.isActive());
        setUrl_image(persona.getUrl_image());
    }

    public PersonaEntity(){

    }

}
