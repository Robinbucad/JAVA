package com.example.relacionTablas.Persona.infraestrucure.controller.input;


import com.example.relacionTablas.Persona.domain.Persona;
import com.example.relacionTablas.Student.domain.Student;
import lombok.Data;

import java.util.Date;

@Data
public class PersonaInputDto {

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

    private Student student;

}
