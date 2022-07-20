package com.example.refactorCRUDbp.Persona.application;

import com.example.refactorCRUDbp.Persona.domain.Persona;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.input.PersonaInputDTO;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.output.PersonaOutputDTO;
import com.example.refactorCRUDbp.Persona.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService implements IPersona{

    @Autowired
    PersonaRepository personaRepository;

    public List<PersonaOutputDTO> getALlPersonas(){
        List<Persona> personas = personaRepository.findAll();
        List<PersonaOutputDTO> personasDTO = new ArrayList<>();
        for (Persona e: personas){
            PersonaOutputDTO persona = new PersonaOutputDTO(e);
            personasDTO.add(persona);
        }
        return personasDTO;

    }
    public PersonaOutputDTO createUser(PersonaInputDTO personaInputDTO) throws Exception{
       if (personaInputDTO.getUsername().length() < 6 || personaInputDTO.getUsername().length() > 10){
           throw new Exception();
       }else {
           Persona persona = new Persona(personaInputDTO);
           personaRepository.save(persona);
           PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
           return personaOutputDTO;
       }
    }


    public PersonaOutputDTO getUserByID(String idPersona)throws Exception{
        if (personaRepository.findByIdPersona(idPersona) == null){
            throw new Exception("404, usuario no existe");
        }else {
            return personaRepository.findByIdPersona(idPersona);
        }
    }

    public PersonaOutputDTO findByUsername(String username) throws Exception{
        if (personaRepository.findByUsername(username) == null){
            throw new Exception();
        }else {
            return personaRepository.findByUsername(username);
        }
    }

    public PersonaOutputDTO deleteUser(String idPersona)throws Exception{

        if (personaRepository.findByIdPersona(idPersona) == null){
            throw new Exception("404, user doesn't exist");
        }else {
            List<Persona> personas = personaRepository.findAll();
            PersonaOutputDTO personaOutputDTO = personaRepository.findByIdPersona(idPersona);
            for (Persona e:personas){
                if (e.getIdPersona() == idPersona){
                    personaRepository.delete(e);
                }
            }
            return personaOutputDTO;
        }
    }

    public PersonaOutputDTO updateUsername(PersonaInputDTO personaInputDTO, String idPersona) throws Exception {
        PersonaOutputDTO personaDTO = personaRepository.findByIdPersona(idPersona);
        List<Persona> personas =personaRepository.findAll();
        for (Persona e:personas){
            if (e.getIdPersona().equals(idPersona)){
                if (personaInputDTO.getUsername().length() < 6 || personaInputDTO.getUsername().length() > 10){
                    throw new Exception();
                }else {
                    personaDTO.setUsername(personaInputDTO.getUsername());
                    e.setUsername(personaInputDTO.getUsername());
                    personaRepository.save(e);
                }

            }
        }
        return personaDTO;
    }

}
