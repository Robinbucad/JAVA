package com.example.refactorCRUDbp.Student.infraestructure.controller.output;

import com.example.refactorCRUDbp.Estudiante_asignatura.domain.EstudianteAsignatura;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.output.EstAsignaturaOutputDTO;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.output.PersonaOutputDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class StudentPersonaOutputDTO {
    private String idStudent;
    private int numHoursWeek;
    private String comments;
    private String branch;

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

    private List<EstudianteAsignatura> estudianteAsignaturaList = new ArrayList<>();

    public StudentPersonaOutputDTO(PersonaOutputDTO persona, StudentOutputDTO studentInputDTO, List<EstudianteAsignatura> estAsignaturaOutputDTO){
        setIdStudent(studentInputDTO.getIdStudent());
        setNumHoursWeek(studentInputDTO.getNumHoursWeek());
        setComments(studentInputDTO.getComments());
        setBranch(studentInputDTO.getBranch());

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
        setEstudianteAsignaturaList(estAsignaturaOutputDTO);
    }

    public StudentPersonaOutputDTO(){

    }
}
