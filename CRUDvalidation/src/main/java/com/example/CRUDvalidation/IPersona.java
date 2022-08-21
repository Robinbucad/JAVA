package com.example.CRUDvalidation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IPersona {

    List<PersonaOutputDTO> getAllPersonas(int page);

    List<PersonaOutputDTO> getPersonasCriteria(Optional<Date> date, String condition);
    PersonaOutputDTO addUser(PersonaInputDTO personaInputDTO)throws Exception;

    PersonaOutputDTO findByUsername(String usuario) throws Exception;

    PersonaOutputDTO findByIdPersona(int idPersona) throws Exception;

    String deletePersona(int idPersona);
}
