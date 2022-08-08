package com.example.relacionTablas.Student.infraestructure.controller.output;


import com.example.relacionTablas.Persona.domain.Persona;
import com.example.relacionTablas.Persona.infraestrucure.controller.output.PersonaOutputDto;
import com.example.relacionTablas.Student.domain.Student;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FullStudentOutputDto{

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

    private String idStudent;
    private int num_hours_week;
    private String comments;
    private String branch;
    public FullStudentOutputDto(StudentOutputDto student, PersonaOutputDto persona){
        setIdStudent(student.getIdStudent());
        setNum_hours_week(student.getNum_hours_week());
        setComments(student.getComments());
        setBranch(student.getBranch());

        setIdPersona(persona.getIdPersona());
        setUsername(persona.getUsername());
        setPassword(persona.getPassword());
        setName(persona.getName());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getPersonal_email());
        setCity(persona.getCity());
        setActive(persona.isActive());
        setCreated_date(persona.getCreated_date());
        setImage_url(persona.getImage_url());
        setTermination_date(persona.getTermination_date());
    }

    public FullStudentOutputDto(){}

}
