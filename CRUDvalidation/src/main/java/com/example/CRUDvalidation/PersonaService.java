package com.example.CRUDvalidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService implements IPersona{

    @Autowired
    PersonaRepository personaRepository;

    public List<PersonaEntity> findAll(){
        return personaRepository.findAll();
    }

    public PersonaOutputDTO addUser(PersonaInputDTO personaInputDTO) throws Exception{
        if (personaInputDTO.getUsuario().length() < 6 || personaInputDTO.getUsuario().length() > 10){
            throw new Exception("El nombre de usuario debe tener entre 6 y 10 caracteres");
        }else {
            PersonaEntity personaEntity = new PersonaEntity(personaInputDTO);
            personaRepository.save(personaEntity);
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaEntity);
            return personaOutputDTO;
        }
    }

    public PersonaOutputDTO findByUsername(String usuario) throws Exception{
        if (personaRepository.findByUsuario(usuario) == null){
            throw new Exception("404, usuario no existe");
        }else {
            return personaRepository.findByUsuario(usuario);
        }
    }

    public PersonaOutputDTO findByIdPersona(int idPersona) throws Exception{
        if (personaRepository.findByIdPersona(idPersona) == null){
            throw new Exception("404, usuario no existe");
        }else {
            return personaRepository.findByIdPersona(idPersona);
        }
    }


}
