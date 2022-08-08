package com.example.relacionTablas.Profesor.application;


import com.example.relacionTablas.Persona.domain.Persona;
import com.example.relacionTablas.Persona.infraestrucure.repository.PersonaRepository;
import com.example.relacionTablas.Profesor.domain.Profesor;
import com.example.relacionTablas.Profesor.infraestructure.controller.input.ProfesorInputDto;
import com.example.relacionTablas.Profesor.infraestructure.controller.output.ProfesorOutputDto;
import com.example.relacionTablas.Profesor.infraestructure.repository.ProfesorRepository;
import com.example.relacionTablas.Student.domain.Student;
import com.example.relacionTablas.Student.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorService implements IProfesor{

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    StudentRepository studentRepository;


    public ProfesorOutputDto createProfesor(ProfesorInputDto profesor){
        Persona persona = personaRepository.findByIdPersona(profesor.getIdPersona());
        Profesor crearProfesor = new Profesor(profesor, persona);
        crearProfesor.setPersona(persona);
        profesorRepository.save(crearProfesor);
        return new ProfesorOutputDto(crearProfesor);
    }

    public List<ProfesorOutputDto> getAllProfesores(){
        List<Profesor> profesorList = profesorRepository.findAll();
        List<ProfesorOutputDto> profesorOutputDtoList = new ArrayList<>();

        for (Profesor p:profesorList){
            ProfesorOutputDto profesorOutputDto = new ProfesorOutputDto(p);
            profesorOutputDtoList.add(profesorOutputDto);
        }
        return profesorOutputDtoList;
    }

    public ProfesorOutputDto getProfesorById(String idProfesor){
        return profesorRepository.findProfesorByIdProfesor(idProfesor);
    }

    public String deleteProfesor(String idProfesor){
        List<Profesor> profesorList = profesorRepository.findAll();
        for (Profesor p:profesorList){
            if (p.getIdProfesor().equals(idProfesor)){
                profesorRepository.delete(p);
            }
        }
        return "Profesor con id " + idProfesor + " borrado correctamente";
    }

}
