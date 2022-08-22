package com.example.refactorCRUDbp.Estudiante_asignatura.application;

import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.input.EstAsignaturaInputDTO;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.output.EstAsignaturaOutputDTO;

import java.util.List;

public interface IEstAsignatura {

    List<EstAsignaturaOutputDTO> getAllAsignaturas();

    EstAsignaturaOutputDTO createAsignatura(EstAsignaturaInputDTO estAsignaturaInputDTO);

    EstAsignaturaOutputDTO getEstAsignaturaById(String idAsignatura) throws Exception;

    EstAsignaturaOutputDTO deleteAsignatura(String idAsignatura) throws Exception;

    EstAsignaturaOutputDTO updateEstudianteAsignatura(EstAsignaturaInputDTO estAsignaturaInputDTO, String idAsignatura);

    boolean addSubjectStudent(String idStudent, String idAsignatura);

}
