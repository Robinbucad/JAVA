package com.example.refactorCRUDbp.Profesor.infraestructure.repository;

import com.example.refactorCRUDbp.Profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, String> {
}
