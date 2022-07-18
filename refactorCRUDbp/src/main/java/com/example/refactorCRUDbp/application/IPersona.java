package com.example.refactorCRUDbp.application;
import com.example.refactorCRUDbp.infraestructure.controler.input.PersonaInputDTO;
import com.example.refactorCRUDbp.infraestructure.controler.output.PersonaOutputDTO;

import java.util.List;

public interface IPersona {

    PersonaOutputDTO createUser(PersonaInputDTO personaInputDTO) throws Exception;
    PersonaOutputDTO getUserByID(int idPersona) throws Exception;

    PersonaOutputDTO findByUsername(String username) throws Exception;
    List<PersonaOutputDTO> getALlPersonas();

}
