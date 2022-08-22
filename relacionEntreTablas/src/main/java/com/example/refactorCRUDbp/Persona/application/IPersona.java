package com.example.refactorCRUDbp.Persona.application;
import com.example.refactorCRUDbp.Persona.domain.Roles;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.input.PersonaInputDTO;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.output.PersonaOutputDTO;

import java.util.List;

public interface IPersona {

    PersonaOutputDTO createUser(PersonaInputDTO personaInputDTO) throws Exception;

    PersonaOutputDTO getUserByID(String idPersona) throws Exception;

    PersonaOutputDTO findByUsername(String username) throws Exception;

    List<PersonaOutputDTO> getALlPersonas();

    PersonaOutputDTO deleteUser(String idPersona) throws Exception;

    PersonaOutputDTO updateUsername(PersonaInputDTO personaInputDTO, String idPersona) throws Exception;

    void addRoleToUser(String username, String rolename);
    Roles saveRole(Roles role);

    List<Roles> getRoles();
}
