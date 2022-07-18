package com.example.CRUDvalidation;

import java.util.List;

public interface IPersona {

    List<PersonaEntity> findAll();
    PersonaOutputDTO addUser(PersonaInputDTO personaInputDTO)throws Exception;

    PersonaOutputDTO findByUsername(String usuario) throws Exception;

    PersonaOutputDTO findByIdPersona(int idPersona) throws Exception;
}
