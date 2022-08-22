package com.example.refactorCRUDbp.Persona.infraestructure.repository;

import com.example.refactorCRUDbp.Persona.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Integer> {

    Roles findByName(String name);

}
