package com.example.CRUDvalidation;

import lombok.Data;

import java.util.Date;


@Data
public class PersonaOutputDTO {

    private int idPersona;
    private String usuario;
    private String name;
    private String password;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;



    public PersonaOutputDTO(PersonaEntity persona){
        setIdPersona(persona.getIdPersona());
        setUsuario(persona.getUsername());
        setName(persona.getName());
        setPassword(persona.getPassword());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getCompany_email());
        setCity(persona.getCity());
        setActive(persona.isActive());
        setImagen_url(persona.getUrl_image());

    }

    public PersonaOutputDTO(){

    }

}
