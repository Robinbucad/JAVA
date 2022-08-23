package com.example.refactorCRUDbp.Persona.domain;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.input.PersonaInputDTO;
import com.example.refactorCRUDbp.Profesor.domain.Profesor;
import com.example.refactorCRUDbp.SequenceIdGenerator.StringPrefixedSequenceIdGenerator;
import com.example.refactorCRUDbp.Student.domain.Student;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
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

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "companyEmail")
    private String company_email;
    @Column(name = "personalEmail")
    private String personal_email;
    @Column(name = "city")
    private String city;
    @Column(name = "active")
    private boolean active;
    @Column(name = "createdDate")
    private Date created_date;
    @Column(name = "imagenCaca")
    private String image_url;
    @Column(name = "terminationDate")
    private Date termination_date;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Roles> roles =new ArrayList<>();

    private boolean admin;

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
