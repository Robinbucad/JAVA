package com.example.refactorCRUDbp.Profesor.infraestructure.repository;

import com.example.refactorCRUDbp.Profesor.domain.Profesor;
import com.example.refactorCRUDbp.Profesor.infraestructure.controller.output.ProfesorOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, String> {

    Profesor getByIdProfesor(String idProfesor);

}
