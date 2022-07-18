package com.example.refactorCRUDbp.application;

import com.example.refactorCRUDbp.domain.Persona;
import com.example.refactorCRUDbp.infraestructure.controler.input.PersonaInputDTO;
import com.example.refactorCRUDbp.infraestructure.controler.output.PersonaOutputDTO;
import com.example.refactorCRUDbp.infraestructure.repository.PersonaRepository;
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

    public PersonaOutputDTO deleteUser(int idPersona)throws Exception{

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

    public PersonaOutputDTO updateUsername(PersonaInputDTO personaInputDTO, int idPersona) throws Exception {
        PersonaOutputDTO personaDTO = personaRepository.findByIdPersona(idPersona);
        List<Persona> personas =personaRepository.findAll();
        for (Persona e:personas){
            if (e.getIdPersona()==idPersona){
                if (personaInputDTO.getUsername().length() < 6 || personaInputDTO.getUsername().length() > 10){
                    throw new Exception("El nombre de usuario debe tener entre 10 y 6 caracteres");
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
