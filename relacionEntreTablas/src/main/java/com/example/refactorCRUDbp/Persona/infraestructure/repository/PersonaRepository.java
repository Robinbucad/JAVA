package com.example.refactorCRUDbp.Persona.infraestructure.repository;

import com.example.refactorCRUDbp.Persona.domain.Persona;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.output.PersonaOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, String> {

    Persona findByIdPersona(String idPersona);
    Persona findByUsername(String username);
}
