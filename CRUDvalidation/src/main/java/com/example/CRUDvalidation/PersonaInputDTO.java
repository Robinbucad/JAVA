package com.example.CRUDvalidation;

import lombok.Data;

import java.util.Date;

@Data
public class PersonaInputDTO {

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

    public PersonaInputDTO(){

    }
}
