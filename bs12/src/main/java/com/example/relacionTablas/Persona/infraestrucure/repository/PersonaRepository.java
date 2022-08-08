package com.example.relacionTablas.Persona.infraestrucure.repository;

import com.example.relacionTablas.Persona.domain.Persona;
import com.example.relacionTablas.Persona.infraestrucure.controller.output.PersonaOutputDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, String> {

    PersonaOutputDto findPersonaByIdPersona(String id_persona);
    Persona findByIdPersona(String id_persona);
}
