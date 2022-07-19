package com.example.refactorCRUDbp.Persona.application;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.input.PersonaInputDTO;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.output.PersonaOutputDTO;

import java.util.List;

public interface IPersona {

    PersonaOutputDTO createUser(PersonaInputDTO personaInputDTO) throws Exception;
    PersonaOutputDTO getUserByID(int idPersona) throws Exception;

    PersonaOutputDTO findByUsername(String username) throws Exception;
    List<PersonaOutputDTO> getALlPersonas();
    PersonaOutputDTO deleteUser(int idPersona) throws Exception;
    PersonaOutputDTO updateUsername(PersonaInputDTO personaInputDTO, int idPersona) throws Exception;
}
