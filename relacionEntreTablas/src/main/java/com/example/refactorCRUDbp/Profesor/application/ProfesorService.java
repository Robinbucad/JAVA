package com.example.refactorCRUDbp.Profesor.application;

import com.example.refactorCRUDbp.Profesor.domain.Profesor;
import com.example.refactorCRUDbp.Profesor.infraestructure.controller.input.ProfesorInputDTO;
import com.example.refactorCRUDbp.Profesor.infraestructure.controller.output.ProfesorOutputDTO;
import com.example.refactorCRUDbp.Profesor.infraestructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorService implements IProfesor{


    @Autowired
    ProfesorRepository profesorRepository;

    public List<ProfesorOutputDTO> getALlProfesores(){
        List<Profesor> profesores = profesorRepository.findAll();
        List<ProfesorOutputDTO> profesorOutputDTOS = new ArrayList<>();
        for (Profesor p : profesores){
            ProfesorOutputDTO profesorDTO = new ProfesorOutputDTO(p);
            profesorOutputDTOS.add(profesorDTO);
        }
    return profesorOutputDTOS;

    }

    public ProfesorOutputDTO createProfesor(ProfesorInputDTO profesorInputDTO){
        Profesor profesor = new Profesor(profesorInputDTO);
        ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(profesor);
        profesorRepository.save(profesor);
        return profesorOutputDTO;
    }

}
