package com.example.CRUDvalidation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersona{

    static final int pageSize = 10;
    @Autowired
    PersonaRepository personaRepository;

    @PersistenceContext
    EntityManager entityManager;



    public List<PersonaOutputDTO> getAllPersonas(int page){
        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<PersonaEntity> configConsulta = cb.createQuery(PersonaEntity.class);
        Root<PersonaEntity> raizPersona = configConsulta.from(PersonaEntity.class);
        TypedQuery<PersonaEntity> typedQuery = entityManager.createQuery(configConsulta.select(raizPersona));
        typedQuery.setFirstResult((page*10)-10);
        typedQuery.setMaxResults(pageSize);

        List<PersonaEntity> personasPaginadas = typedQuery.getResultList();

        for (PersonaEntity p: personasPaginadas){
            PersonaOutputDTO newPersonaOutput = new PersonaOutputDTO(p);
            personaOutputDTOList.add(newPersonaOutput);
        }
        return personaOutputDTOList;
    }

    public List<PersonaOutputDTO> getPersonasCriteria(Optional<Date> date, String condition){
        List<PersonaOutputDTO> personaOutputDTOList = new ArrayList<>();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonaEntity> configConsulta = cb.createQuery(PersonaEntity.class);
        Root<PersonaEntity> raizPersona = configConsulta.from(PersonaEntity.class);
        configConsulta.select(raizPersona);

        if (condition.equals("mayor")){
            configConsulta.where(cb.greaterThan(raizPersona.get("creation_date"), date.get()));
        }
        if (condition.equals("menor")){
            configConsulta.where(cb.lessThan(raizPersona.get("creation_date"), date.get()));
        }

        List<PersonaEntity> personas = entityManager.createQuery(configConsulta).getResultList();


        for (PersonaEntity p: personas){
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(p);
            personaOutputDTOList.add(personaOutputDTO);
        }
        return personaOutputDTOList;
    }


    public PersonaOutputDTO addUser(PersonaInputDTO personaInputDTO) throws Exception{
        if (personaInputDTO.username().length() < 6 || personaInputDTO.username().length() > 10){
            throw new Exception("El nombre de usuario debe tener entre 6 y 10 caracteres");
        }else {
            PersonaEntity personaEntity = new PersonaEntity(personaInputDTO);
            personaRepository.save(personaEntity);
            PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaEntity);
            return personaOutputDTO;
        }
    }

    public PersonaOutputDTO findByUsername(String usuario) throws Exception{
        if (personaRepository.findByUsername(usuario) == null){
            throw new Exception("404, usuario no existe");
        }else {
            return personaRepository.findByUsername(usuario);
        }
    }

    public PersonaOutputDTO findByIdPersona(int idPersona) throws Exception{
        if (personaRepository.findByIdPersona(idPersona) == null){
            throw new Exception("404, usuario no existe");
        }else {
            PersonaEntity persona = personaRepository.findById(idPersona).orElseThrow();
            return new PersonaOutputDTO(persona);
        }
    }

    public String deletePersona(int idPersona){
        List<PersonaEntity> personaEntities = personaRepository.findAll();
        PersonaOutputDTO personaOutputDTO = personaRepository.findByIdPersona(idPersona);
        for (PersonaEntity p: personaEntities){
            if (p.getIdPersona() == idPersona){
                personaRepository.delete(p);
            }
        }
        return "Persona con id " + idPersona + " borrada correctamente";
    }



}
