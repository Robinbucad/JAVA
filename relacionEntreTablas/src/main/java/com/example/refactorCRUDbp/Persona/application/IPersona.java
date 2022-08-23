package com.example.refactorCRUDbp.Persona.application;
import com.example.refactorCRUDbp.Persona.domain.Roles;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.input.PersonaInputDTO;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.output.PersonaOutputDTO;

import java.util.List;

public interface IPersona {

    PersonaOutputDTO createUser(PersonaInputDTO personaInputDTO);

    PersonaOutputDTO getUserByID(String idPersona);

    PersonaOutputDTO findByUsername(String username);

    List<PersonaOutputDTO> getALlPersonas();

    String deleteUser(String idPersona);

    PersonaOutputDTO updateUsername(PersonaInputDTO personaInputDTO, String idPersona);

    void addRoleToUser(String username, String rolename);
    Roles saveRole(Roles role);

    List<Roles> getRoles();
}
