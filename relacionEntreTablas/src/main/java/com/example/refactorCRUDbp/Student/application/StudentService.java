package com.example.refactorCRUDbp.Student.application;

import com.example.refactorCRUDbp.Persona.domain.Persona;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.output.PersonaOutputDTO;
import com.example.refactorCRUDbp.Persona.infraestructure.repository.PersonaRepository;
import com.example.refactorCRUDbp.Student.domain.Student;
import com.example.refactorCRUDbp.Student.infraestructure.controller.input.StudentInputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentOutputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentPersonaOutputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudent{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonaRepository personaRepository;

    public List<StudentOutputDTO> getALlStudents(){
        List<Student> students = studentRepository.findAll();
        List<StudentOutputDTO> studentOutputDTO = new ArrayList<>();
        for (Student s:students){
            StudentOutputDTO student = new StudentOutputDTO(s);
            studentOutputDTO.add(student);
        }
        return studentOutputDTO;
    }

    public StudentOutputDTO createStudent(StudentInputDTO studentInputDTO){
        Student student = new Student(studentInputDTO);
        StudentOutputDTO studentOutputDTO = new StudentOutputDTO(student);
        studentRepository.save(student);
        return studentOutputDTO;
    }

    public StudentOutputDTO getStudentById(String idStudent)throws Exception{
        if (studentRepository.getStudentByIdStudent(idStudent) != null){
            return studentRepository.getStudentByIdStudent(idStudent);
        }else {
            throw new  Exception();
        }
    }

    public StudentPersonaOutputDTO getStudentPersona(String idStudent) throws Exception{

        if (studentRepository.getStudentPersonaByIdStudent(idStudent)!=null){
            PersonaOutputDTO personaOutputDTO = personaRepository.findByIdPersona(idStudent);
            StudentOutputDTO studentOutputDTO = studentRepository.getStudentByIdStudent(idStudent);

            StudentPersonaOutputDTO studentPersonaOutputDTO = new StudentPersonaOutputDTO(personaOutputDTO, studentOutputDTO);
            return studentPersonaOutputDTO;
        }else {
            throw new Exception();
        }


    }


}
