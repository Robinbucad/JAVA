package com.example.refactorCRUDbp.Profesor.application;

import com.example.refactorCRUDbp.Persona.domain.Persona;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.output.PersonaOutputDTO;
import com.example.refactorCRUDbp.Persona.infraestructure.repository.PersonaRepository;
import com.example.refactorCRUDbp.Profesor.domain.Profesor;
import com.example.refactorCRUDbp.Profesor.infraestructure.controller.input.ProfesorInputDTO;
import com.example.refactorCRUDbp.Profesor.infraestructure.controller.output.ProfesorOutputDTO;
import com.example.refactorCRUDbp.Profesor.infraestructure.controller.output.ProfesorPersonaOutputDTO;
import com.example.refactorCRUDbp.Profesor.infraestructure.repository.ProfesorRepository;
import com.example.refactorCRUDbp.Student.domain.Student;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentOutputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.OrientationRequested;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorService implements IProfesor{


    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    StudentRepository studentRepository;

    public List<ProfesorOutputDTO> getALlProfesores(){
        List<Profesor> profesores = profesorRepository.findAll();
        List<ProfesorOutputDTO> profesorOutputDTOS = new ArrayList<>();
        for (Profesor p : profesores){
            ProfesorOutputDTO profesorDTO = new ProfesorOutputDTO(p);
            profesorOutputDTOS.add(profesorDTO);
        }
    return profesorOutputDTOS;

    }

    public ProfesorOutputDTO createProfesor(ProfesorInputDTO profesorInputDTO) throws Exception{
        Student student = studentRepository.findById(profesorInputDTO.getIdPersona()).orElse(null);
        Persona persona = personaRepository.findByIdPersona(profesorInputDTO.getIdPersona());
        Profesor profesor = new Profesor(profesorInputDTO,persona);

        if (student == null){
            ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(profesor);
            profesorRepository.save(profesor);
            return profesorOutputDTO;
        }else {
            throw new Exception();
        }

    }

    public String deleteProfesor(String idProfesor){
        List<Profesor> profesores = profesorRepository.findAll();

        for (Profesor p: profesores){
            if (p.getIdProfesor().equals(idProfesor)){
                profesorRepository.delete(p);
            }
        }

        return "Profesor con id "+ idProfesor + " borrado correctamente";
    }

    public ProfesorOutputDTO getProfesorById(String idProfesor) throws Exception{
        if (profesorRepository.getByIdProfesor(idProfesor) != null){
            return new ProfesorOutputDTO(profesorRepository.findById(idProfesor).orElse(null));
        }else {
            throw new Exception();
        }
    }
    public ProfesorPersonaOutputDTO getFullProfesor(String idProfesor)throws Exception{

        if (profesorRepository.getByIdProfesor(idProfesor)!= null){
            Persona persona = personaRepository.findByIdPersona(idProfesor);
            Profesor profesor = profesorRepository.findById(idProfesor).orElse(null);
            ProfesorPersonaOutputDTO profesorPersonaOutputDTO = new ProfesorPersonaOutputDTO(new ProfesorOutputDTO(profesor),new PersonaOutputDTO(persona));
            return profesorPersonaOutputDTO;
        }else {
            throw new Exception();
        }
    }

}
