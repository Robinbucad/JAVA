package com.example.refactorCRUDbp.infraestructure.repository;

import com.example.refactorCRUDbp.domain.Persona;
import com.example.refactorCRUDbp.infraestructure.controler.output.PersonaOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, String> {

    PersonaOutputDTO findByIdPersona(int idPersona);
    PersonaOutputDTO findByUsername(String username);
}
