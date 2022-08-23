package com.example.refactorCRUDbp.Profesor.infraestructure.controller.output;

import com.example.refactorCRUDbp.Estudiante_asignatura.domain.EstudianteAsignatura;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.output.PersonaOutputDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ProfesorPersonaOutputDTO {

    private String idProfesor;
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

    private List<EstudianteAsignatura> asignaturasImpartir = new ArrayList<>();

    public ProfesorPersonaOutputDTO(ProfesorOutputDTO profesorOutputDTO, PersonaOutputDTO personaOutputDTO, List<EstudianteAsignatura> estudianteAsignatura){
        setIdProfesor(profesorOutputDTO.getIdProfesor());
        setComments(profesorOutputDTO.getComments());
        setBranch(profesorOutputDTO.getBranch());
        setAsignaturasImpartir(estudianteAsignatura);

        setIdPersona(personaOutputDTO.getIdPersona());
        setUsername(personaOutputDTO.getUsername());
        setPassword(personaOutputDTO.getPassword());
        setName(personaOutputDTO.getName());
        setSurname(personaOutputDTO.getSurname());
        setCompany_email(personaOutputDTO.getCompany_email());
        setPersonal_email(personaOutputDTO.getPersonal_email());
        setCity(personaOutputDTO.getCity());
        setActive(personaOutputDTO.isActive());
        setCreated_date(personaOutputDTO.getCreated_date());
        setImage_url(personaOutputDTO.getImage_url());
        setTermination_date(personaOutputDTO.getTermination_date());
    }

}
