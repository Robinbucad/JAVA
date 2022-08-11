package com.example.CRUDvalidation;

import lombok.Data;

import java.util.Date;

@Data
public class PersonaInputDTO {

    private String username;
    private String name;
    private String password;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private String url_image;


    public PersonaInputDTO(){

    }
}
