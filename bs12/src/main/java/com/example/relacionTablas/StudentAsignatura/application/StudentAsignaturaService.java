package com.example.relacionTablas.StudentAsignatura.application;


import com.example.relacionTablas.Persona.domain.Persona;
import com.example.relacionTablas.Persona.infraestrucure.repository.PersonaRepository;
import com.example.relacionTablas.StudentAsignatura.domain.StudentAsignatura;
import com.example.relacionTablas.StudentAsignatura.infraestructure.controller.input.StudentAsignaturaInputDto;
import com.example.relacionTablas.StudentAsignatura.infraestructure.controller.output.StudentAsignaturaOutputDto;
import com.example.relacionTablas.StudentAsignatura.infraestructure.repository.StudentAsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentAsignaturaService implements IStudentAsignatura {

    @Autowired
    StudentAsignaturaRepository studentAsignaturaRepository;

    @Autowired
    PersonaRepository personaRepository;

    public List<StudentAsignaturaOutputDto> getAllStudentAsignatura(){
        List<StudentAsignatura> studentAsignaturaList =studentAsignaturaRepository.findAll();
        List<StudentAsignaturaOutputDto> studentOutputDtos = new ArrayList<>();

        for (StudentAsignatura s:studentAsignaturaList){
            StudentAsignaturaOutputDto studentAsignaturaOutputDto = new StudentAsignaturaOutputDto(s);
            studentOutputDtos.add(studentAsignaturaOutputDto);
        }
        return studentOutputDtos;
    }

    public StudentAsignaturaOutputDto createStudentAsginatura(StudentAsignaturaInputDto studentAsignaturaInputDto){
        Persona persona = personaRepository.findByIdPersona(studentAsignaturaInputDto.getIdPersona());
        StudentAsignatura studentAsignatura = new StudentAsignatura(studentAsignaturaInputDto,persona);
        studentAsignaturaRepository.save(studentAsignatura);

        StudentAsignaturaOutputDto studentAsignaturaOutputDto = new StudentAsignaturaOutputDto(studentAsignatura);
        return studentAsignaturaOutputDto;
    }

    public StudentAsignaturaOutputDto findStudentAsignaturaByIdAsignatura(String idAsignatura){
        return studentAsignaturaRepository.findStudentAsignaturaByIdAsignatura(idAsignatura);
    }

    public StudentAsignaturaOutputDto updateStudentAsignatura(String idAsignatura, StudentAsignaturaInputDto student){
        StudentAsignatura studentAsignatura = studentAsignaturaRepository.findByIdAsignatura(idAsignatura);
        studentAsignatura.update(student);
        studentAsignaturaRepository.save(studentAsignatura);

        StudentAsignaturaOutputDto studentAsignaturaOutputDto = new StudentAsignaturaOutputDto(studentAsignatura);
        return studentAsignaturaOutputDto;
    }

    public String deleteStudentAsignatura(String idAsignatura){
        List<StudentAsignatura> studentAsignaturaList = studentAsignaturaRepository.findAll();
        for (StudentAsignatura s:studentAsignaturaList){
            if (s.getIdAsignatura().equals(idAsignatura)){
                studentAsignaturaRepository.delete(s);
            }
        }
        return "Estudiante con id " + idAsignatura + " borrado correctamente";
    }

}
