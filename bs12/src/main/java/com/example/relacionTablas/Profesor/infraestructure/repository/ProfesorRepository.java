package com.example.relacionTablas.Profesor.infraestructure.repository;

import com.example.relacionTablas.Profesor.domain.Profesor;
import com.example.relacionTablas.Profesor.infraestructure.controller.output.ProfesorOutputDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor,String> {

    ProfesorOutputDto findProfesorByIdProfesor(String idProfesor);

    Profesor findByIdProfesor(String idProfesor);

}
