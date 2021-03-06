package com.example.CRUDvalidation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, String> {
    PersonaOutputDTO findByUsuario(String usuario);
    PersonaOutputDTO findByIdPersona(int idPersona);
}
