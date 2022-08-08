package com.example.relacionTablas.Persona.domain;

import com.example.relacionTablas.Persona.infraestrucure.controller.input.PersonaInputDto;
import com.example.relacionTablas.Profesor.domain.Profesor;
import com.example.relacionTablas.SequenceIdGenerator.StringPrefixedSequenceIdGenerator;
import com.example.relacionTablas.Student.domain.Student;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.repository.query.Param;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personas")
    @GenericGenerator(
            name = "personas",
            strategy = "com.example.relacionTablas.SequenceIdGenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            }
    )
    @Column(name = "id_persona")
   private String idPersona;
    @Column(name = "username")
   private String username;
    @Column(name = "password")
   private String password;
    @Column(name = "name")
   private String name;
    @Column(name = "surname")
   private String surname;
    @Column(name = "comapny_email")
   private String company_email;
    @Column(name = "personal_email")
   private String personal_emal;
    @Column(name = "city")
   private String city;
    @Column(name = "active")
   private boolean active;
    @Column(name = "created_date")
   private Date created_date;
    @Column(name = "imagen_url")
   private String imagen_url;
    @Column(name = "termination_date")
   private Date termination_date;


    public Persona(PersonaInputDto personaInputDTO){
        setUsername(personaInputDTO.getUsername());
        setPassword(personaInputDTO.getPassword());
        setName(personaInputDTO.getName());
        setSurname(personaInputDTO.getSurname());
        setCompany_email(personaInputDTO.getCompany_email());
        setPersonal_emal(personaInputDTO.getPersonal_email());
        setCity(personaInputDTO.getCity());
        setActive(personaInputDTO.isActive());
        setCreated_date(personaInputDTO.getCreated_date());
        setImagen_url(personaInputDTO.getImage_url());
        setTermination_date(personaInputDTO.getTermination_date());
    }

    public Persona(){

    };

    public void update(@NotNull PersonaInputDto personInputDTO) {
        if (personInputDTO.getUsername() != null
                && personInputDTO.getUsername().length() >= 6
                && personInputDTO.getUsername().length() <= 10) {
            setUsername(personInputDTO.getUsername());
        }
        if (personInputDTO.getName() != null) {
            setName(personInputDTO.getName());
        }
        if (personInputDTO.getSurname() != null) {
            setSurname(personInputDTO.getSurname());
        }
        if (personInputDTO.getPassword() != null) {
            setPassword(personInputDTO.getPassword());
        }
        if (personInputDTO.getCompany_email() != null) {
            setCompany_email(personInputDTO.getCompany_email());
        }
        if (personInputDTO.getPersonal_email()!= null) {
            setPersonal_emal(personInputDTO.getPersonal_email());
        }
        if (personInputDTO.getCity() != null) {
            setCity(personInputDTO.getCity());
        }
        if (personInputDTO.getImage_url() != null) {
            setImagen_url(personInputDTO.getImage_url());
        }
    }

}
