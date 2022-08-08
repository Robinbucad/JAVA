package com.example.relacionTablas.Persona.application;

import com.example.relacionTablas.Persona.infraestrucure.controller.input.PersonaInputDto;
import com.example.relacionTablas.Persona.infraestrucure.controller.output.PersonaOutputDto;

import java.util.List;

public interface IPersona {

    PersonaOutputDto createPersona(PersonaInputDto personaInputDto) throws Exception;

    List<PersonaOutputDto> getAllPersonas();

    PersonaOutputDto findPersonaById(String idPersona) throws Exception;

    PersonaOutputDto updatePersona(String idPersona, PersonaInputDto personaInputDto);

    String deletePersona(String idPersona);

}
