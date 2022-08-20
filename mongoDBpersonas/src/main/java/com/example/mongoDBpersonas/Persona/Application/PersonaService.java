package com.example.mongoDBpersonas.Persona.Application;

import com.example.mongoDBpersonas.Persona.Domain.PersonaEntity;
import com.example.mongoDBpersonas.Persona.Infraestructure.Controller.Input.PersonaInputDTO;
import com.example.mongoDBpersonas.Persona.Infraestructure.Controller.Output.PersonaOutputDTO;
import com.example.mongoDBpersonas.Persona.Infraestructure.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService implements IPersona{

    @Autowired
    PersonaRepository personaRepository;

    public List<PersonaOutputDTO> getAllPersonas(){
        List<PersonaEntity> personaEntities = personaRepository.findAll();
        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();

        for (PersonaEntity p: personaEntities){
            PersonaOutputDTO newPersona = new PersonaOutputDTO(p);
            personaOutputDTOList.add(newPersona);
        }
        return personaOutputDTOList;

    }

    public PersonaOutputDTO createPersona(PersonaInputDTO personaInputDTO){
        PersonaEntity persona = new PersonaEntity(personaInputDTO);
        personaRepository.save(persona);

        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
        return personaOutputDTO;

    }

    public PersonaOutputDTO getPersonaById(int idPersona){
       PersonaEntity persona = personaRepository.findById(idPersona).orElse(null);
       PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
       return personaOutputDTO;
    }

    public String deletePersona(int idPersona){
        PersonaEntity persona = personaRepository.findById(idPersona).orElse(null);
        personaRepository.delete(persona);
        return "Persona con id " + idPersona + " borrada correctamente";
    }

    public PersonaOutputDTO updatePersona(PersonaInputDTO personaInputDTO, int idPersona){
        PersonaEntity persona = personaRepository.findById(idPersona).orElse(null);
        persona.updatePersona(personaInputDTO);
        personaRepository.save(persona);

        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
        return personaOutputDTO;
    }

}
