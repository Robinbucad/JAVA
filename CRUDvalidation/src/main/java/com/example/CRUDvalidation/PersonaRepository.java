package com.example.CRUDvalidation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {

    PersonaOutputDTO findByUsername(String username);
    PersonaOutputDTO findByIdPersona(int idPersona);
}
