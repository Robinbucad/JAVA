package com.example.refactorCRUDbp.Estudiante_asignatura.application;

import com.example.refactorCRUDbp.Estudiante_asignatura.domain.EstudianteAsignatura;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.input.EstAsignaturaInputDTO;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.output.EstAsignaturaOutputDTO;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.repository.EstAsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstAsignaturaService implements IEstAsignatura{

    @Autowired
    EstAsignaturaRepository estAsignaturaRepository;

    public List<EstAsignaturaOutputDTO> getAllAsignaturas(){
        List<EstudianteAsignatura> estudianteAsignatura = estAsignaturaRepository.findAll();
        List<EstAsignaturaOutputDTO> estAsignaturaOutputDTOList = new ArrayList<>();

        for (EstudianteAsignatura e:estudianteAsignatura){
            EstAsignaturaOutputDTO estAsign = new EstAsignaturaOutputDTO(e);
            estAsignaturaOutputDTOList.add(estAsign);
        }
    return estAsignaturaOutputDTOList;

    }

    public EstAsignaturaOutputDTO createAsignatura(EstAsignaturaInputDTO estAsignaturaInputDTO){
         EstudianteAsignatura estudianteAsignatura = new EstudianteAsignatura(estAsignaturaInputDTO);
         estAsignaturaRepository.save(estudianteAsignatura);

         EstAsignaturaOutputDTO estAsignaturaOutputDTO = new EstAsignaturaOutputDTO(estudianteAsignatura);
         return estAsignaturaOutputDTO;

    }

    public EstAsignaturaOutputDTO getEstAsignaturaById(String idAsignatura)throws Exception{

        if (estAsignaturaRepository.findByIdAsignatura(idAsignatura) == null){
            throw new Exception();
        }
        else {
            return estAsignaturaRepository.findByIdAsignatura(idAsignatura);
        }
    }



}
