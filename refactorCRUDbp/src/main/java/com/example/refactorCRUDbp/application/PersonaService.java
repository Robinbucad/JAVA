package com.example.refactorCRUDbp.application;

import com.example.refactorCRUDbp.domain.Persona;
import com.example.refactorCRUDbp.infraestructure.controler.input.PersonaInputDTO;
import com.example.refactorCRUDbp.infraestructure.controler.output.PersonaOutputDTO;
import com.example.refactorCRUDbp.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersona{

    @Autowired
    PersonaRepository personaRepository;

    public PersonaOutputDTO createUser(PersonaInputDTO personaInputDTO) throws Exception{
       if (personaInputDTO.getUsername().length() < 6 || personaInputDTO.getUsername().length() > 10){
           throw new Exception("El nombre de usuario debe tener entre 6 y 10 caracteres");
       }else {
           Persona persona = new Persona(personaInputDTO);
           personaRepository.save(persona);
           PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
           return personaOutputDTO;
       }
    }


    public PersonaOutputDTO getUserByID(int idPersona)throws Exception{
        if (personaRepository.findByIdPersona(idPersona) == null){
            throw new Exception("404, usuario no existe");
        }else {
            return personaRepository.findByIdPersona(idPersona);
        }
    }

    public PersonaOutputDTO findByUsername(String username) throws Exception{
        if (personaRepository.findByUsername(username) == null){
            throw new Exception("404, usuario no existe");
        }else {
            return personaRepository.findByUsername(username);
        }
    }


}
