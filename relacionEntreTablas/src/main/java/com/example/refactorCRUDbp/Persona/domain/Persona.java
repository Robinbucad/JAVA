package com.example.refactorCRUDbp.Persona.domain;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.input.PersonaInputDTO;
import com.example.refactorCRUDbp.SequenceIdGenerator.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "Persona")
@Entity(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personas")
    @GenericGenerator(
            name = "personas",
            strategy = "com.example.refactorCRUDbp.SequenceIdGenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),

            }
    )
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

    public Persona(PersonaInputDTO personaInputDTO){
        setIdPersona(personaInputDTO.getIdPersona());
        setUsername(personaInputDTO.getUsername());
        setPassword(personaInputDTO.getPassword());
        setName(personaInputDTO.getName());
        setSurname(personaInputDTO.getSurname());
        setCompany_email(personaInputDTO.getCompany_email());
        setPersonal_email(personaInputDTO.getPersonal_email());
        setCity(personaInputDTO.getCity());
        setActive(personaInputDTO.isActive());
        setCreated_date(personaInputDTO.getCreated_date());
        setImage_url(personaInputDTO.getImage_url());
        setTermination_date(personaInputDTO.getTermination_date());
    }

    public Persona(){

    };

}
