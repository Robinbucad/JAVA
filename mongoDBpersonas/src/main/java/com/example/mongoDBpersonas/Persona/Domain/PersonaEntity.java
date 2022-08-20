package com.example.mongoDBpersonas.Persona.Domain;

import com.example.mongoDBpersonas.Persona.Infraestructure.Controller.Input.PersonaInputDTO;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(value = "persona")
@Data

public class PersonaEntity {

    @Id
    private int idPersona;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private boolean active;
    private Date creation_date;
    private Date termination_date;
    private String image_url;


    public PersonaEntity(PersonaInputDTO personaInputDTO){
        setIdPersona(personaInputDTO.idPersona());
        setUsername(personaInputDTO.username());
        setPassword(personaInputDTO.password());
        setName(personaInputDTO.name());
        setSurname(personaInputDTO.surname());
        setCompany_email(personaInputDTO.company_email());
        setPersonal_email(personaInputDTO.personal_email());
        setCity(personaInputDTO.city());
        setActive(personaInputDTO.active());
        setCreation_date(personaInputDTO.creation_date());
        setTermination_date(personaInputDTO.termination_date());
        setImage_url(personaInputDTO.image_url());
    }

    public void updatePersona(PersonaInputDTO personaInputDTO){
        setUsername(personaInputDTO.username());
        setPassword(personaInputDTO.password());
        setName(personaInputDTO.name());
        setSurname(personaInputDTO.surname());
        setCompany_email(personaInputDTO.company_email());
        setPersonal_email(personaInputDTO.personal_email());
        setCity(personaInputDTO.city());
        setActive(personaInputDTO.active());
        setCreation_date(personaInputDTO.creation_date());
        setTermination_date(personaInputDTO.termination_date());
        setImage_url(personaInputDTO.image_url());
    }

    public PersonaEntity(){};
}
