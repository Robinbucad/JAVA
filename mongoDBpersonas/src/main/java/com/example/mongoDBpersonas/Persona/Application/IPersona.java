package com.example.mongoDBpersonas.Persona.Application;

import com.example.mongoDBpersonas.Persona.Infraestructure.Controller.Input.PersonaInputDTO;
import com.example.mongoDBpersonas.Persona.Infraestructure.Controller.Output.PersonaOutputDTO;

import java.util.List;

public interface IPersona {

    List<PersonaOutputDTO> getAllPersonas();

    PersonaOutputDTO createPersona(PersonaInputDTO personaInputDTO);

    PersonaOutputDTO getPersonaById(int idPersona);

    String deletePersona(int idPersona);

    PersonaOutputDTO updatePersona(PersonaInputDTO personaInputDTO, int idPersona);


    }
