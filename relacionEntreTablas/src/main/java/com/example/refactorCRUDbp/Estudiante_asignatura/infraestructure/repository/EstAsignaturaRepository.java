package com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.repository;

import com.example.refactorCRUDbp.Estudiante_asignatura.domain.EstudianteAsignatura;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.output.EstAsignaturaOutputDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstAsignaturaRepository extends JpaRepository<EstudianteAsignatura,String> {

    EstAsignaturaOutputDTO findByIdAsignatura(String idAsignatura);
    
}
