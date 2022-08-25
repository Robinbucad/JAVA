package com.jdbcTemplate.persona.domain;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Table(name = "personas")
@Entity
@Data
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_persona;
    private String username;

    private String name;

    private String password;

    private String surname;

    private String company_email;

    private String personal_email;

    private String city;

    private boolean active;

    private String url_image;

    LocalDate creation_date;
    LocalDate termination_date;

}
