package com.example.mongoDBpersonas.Persona.Infraestructure.Repository;

import com.example.mongoDBpersonas.Persona.Domain.PersonaEntity;
import com.example.mongoDBpersonas.Persona.Infraestructure.Controller.Output.PersonaOutputDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonaRepository extends MongoRepository<PersonaEntity, Integer> {

}
