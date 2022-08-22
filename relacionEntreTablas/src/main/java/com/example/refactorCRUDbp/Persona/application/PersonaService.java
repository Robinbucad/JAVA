package com.example.refactorCRUDbp.Persona.application;

import com.example.refactorCRUDbp.Persona.domain.Persona;
import com.example.refactorCRUDbp.Persona.domain.Roles;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.input.PersonaInputDTO;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.output.PersonaOutputDTO;
import com.example.refactorCRUDbp.Persona.infraestructure.repository.PersonaRepository;
import com.example.refactorCRUDbp.Persona.infraestructure.repository.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonaService implements IPersona, UserDetailsService {


    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    RolesRepository rolesRepository;

    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Persona persona = personaRepository.findByUsername(username);
        if (persona == null){
            throw new UsernameNotFoundException("Persona no existe");
        }else {
            System.out.println("Not found " + username);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        persona.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(persona.getUsername(),persona.getPassword(), authorities);
    }

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
           personaInputDTO.setPassword(passwordEncoder.encode(personaInputDTO.getPassword()));
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
            return new PersonaOutputDTO(personaRepository.findByIdPersona(idPersona));
        }
    }

    public PersonaOutputDTO findByUsername(String username) throws Exception{
        if (personaRepository.findByUsername(username) == null){
            throw new Exception();
        }else {
             return new PersonaOutputDTO(personaRepository.findByUsername(username));
        }
    }

    public PersonaOutputDTO deleteUser(String idPersona)throws Exception{

        if (personaRepository.findByIdPersona(idPersona) == null){
            throw new Exception("404, user doesn't exist");
        }else {
            List<Persona> personas = personaRepository.findAll();
            Persona persona = personaRepository.findByIdPersona(idPersona);
            for (Persona e:personas){
                if (e.getIdPersona().equals(idPersona)){
                    personaRepository.delete(e);
                }
            }
            return new PersonaOutputDTO(persona);
        }
    }

    public PersonaOutputDTO updateUsername(PersonaInputDTO personaInputDTO, String idPersona) throws Exception {
        Persona persona = personaRepository.findByIdPersona(idPersona);
        List<Persona> personas =personaRepository.findAll();
        for (Persona e:personas){
            if (e.getIdPersona().equals(idPersona)){
                if (personaInputDTO.getUsername().length() < 6 || personaInputDTO.getUsername().length() > 10){
                    throw new Exception();
                }else {
                    persona.setUsername(personaInputDTO.getUsername());
                    e.setUsername(personaInputDTO.getUsername());
                    personaRepository.save(e);
                }

            }
        }
        return new PersonaOutputDTO(persona);
    }

    public Roles saveRole(Roles role){
        return rolesRepository.save(role);
    }

    public void addRoleToUser(String username, String rolename){
        Persona persona = personaRepository.findByUsername(username);
        Roles role = rolesRepository.findByName(rolename);
        persona.getRoles().add(role);
    }

    public List<Roles> getRoles(){
        return rolesRepository.findAll();
    }

}
