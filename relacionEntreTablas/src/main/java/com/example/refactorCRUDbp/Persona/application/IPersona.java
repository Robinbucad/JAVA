package com.example.refactorCRUDbp.Persona.application;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.input.PersonaInputDTO;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.output.PersonaOutputDTO;
import com.example.refactorCRUDbp.Student.domain.Student;

import java.util.List;
import java.util.Optional;

public interface IPersona {

    PersonaOutputDTO createUser(PersonaInputDTO personaInputDTO) throws Exception;
    PersonaOutputDTO getUserByID(String idPersona) throws Exception;

    PersonaOutputDTO findByUsername(String username) throws Exception;
    List<PersonaOutputDTO> getALlPersonas();
    PersonaOutputDTO deleteUser(String idPersona) throws Exception;
    PersonaOutputDTO updateUsername(PersonaInputDTO personaInputDTO, String idPersona) throws Exception;
}
