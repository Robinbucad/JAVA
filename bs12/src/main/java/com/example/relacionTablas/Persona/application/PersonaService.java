package com.example.relacionTablas.Persona.application;

import com.example.relacionTablas.Persona.domain.Persona;
import com.example.relacionTablas.Persona.infraestrucure.controller.input.PersonaInputDto;
import com.example.relacionTablas.Persona.infraestrucure.controller.output.PersonaOutputDto;
import com.example.relacionTablas.Persona.infraestrucure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService implements IPersona{

    @Autowired
    PersonaRepository personaRepository;

    public PersonaOutputDto createPersona(PersonaInputDto personaInputDto) throws Exception{
        if (personaInputDto.getUsername().length() < 6 || personaInputDto.getUsername().length() > 10){
            throw new Exception();

        }else {
            Persona persona = new Persona(personaInputDto);
            personaRepository.save(persona);
            PersonaOutputDto personaOutputDto = new PersonaOutputDto(persona);
            return personaOutputDto;
        }
    }

    public List<PersonaOutputDto> getAllPersonas(){
        List<Persona> personas = personaRepository.findAll();
        List<PersonaOutputDto> personasOutputDto = new ArrayList<>();

        for (Persona p: personas){
            PersonaOutputDto personaOutputDto = new PersonaOutputDto(p);
            personasOutputDto.add(personaOutputDto);
        }
        return personasOutputDto;
    }

    public PersonaOutputDto findPersonaById(String idPersona)throws Exception{
        if (personaRepository.findPersonaByIdPersona(idPersona)== null){
            throw new Exception("Usuario no existe");
        }
        else {
            return personaRepository.findPersonaByIdPersona(idPersona);
        }
    }

    public PersonaOutputDto updatePersona(String idPersona, PersonaInputDto personaInputDto){
        Persona personaUpdate = personaRepository.findByIdPersona(idPersona);
        personaUpdate.update(personaInputDto);
        personaRepository.save(personaUpdate);
        return new PersonaOutputDto(personaUpdate);
    }

    public String deletePersona(String idPersona){
        List<Persona> personaList = personaRepository.findAll();
        for (Persona p:personaList){
            if (p.getIdPersona().equals(idPersona)){
                personaRepository.delete(p);
            }
        }
        return "Persona con id " + idPersona + " borrada correctamente";
    }

}
