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
    @Column(name = "id_persona")
    private int idPersona;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "nombre")
    private String name;

    @Column(name = "contraseña")
    private String password;

    @Column(name = "apellidos")
    private String surname;

    @Column(name = "EmailTrabajo")
    private String company_email;

    @Column(name = "EmailPersonal")
    private String personal_email;

    @Column(name = "Ciudad")
    private String city;

    @Column(name = "Activo")
    private boolean active;

    @Column(name = "FechaCreacion")
    private Date created_date;

    @Column(name = "ImagenUrl")
    private String imagen_url;

    @Column(name = "FechaFin")
    private Date termination_date;

    public PersonaEntity(PersonaInputDTO persona){

        setIdPersona(persona.getIdPersona());
        setUsuario(persona.getUsuario());
        setName(persona.getName());
        setPassword(persona.getPassword());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getCompany_email());
        setCity(persona.getCity());
        setActive(persona.isActive());
        setCreated_date(persona.getCreated_date());
        setImagen_url(persona.getImagen_url());
        setTermination_date(persona.getTermination_date());

    }

    public PersonaEntity(){

    }

}
