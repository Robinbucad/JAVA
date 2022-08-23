package com.example.refactorCRUDbp.Student.application;

import com.example.refactorCRUDbp.Estudiante_asignatura.domain.EstudianteAsignatura;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.repository.EstAsignaturaRepository;
import com.example.refactorCRUDbp.Persona.domain.Persona;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.input.PersonaInputDTO;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.output.PersonaOutputDTO;
import com.example.refactorCRUDbp.Persona.infraestructure.repository.PersonaRepository;
import com.example.refactorCRUDbp.Profesor.domain.Profesor;
import com.example.refactorCRUDbp.Profesor.infraestructure.repository.ProfesorRepository;
import com.example.refactorCRUDbp.Student.domain.Student;
import com.example.refactorCRUDbp.Student.infraestructure.controller.input.StudentInputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentOutputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentPersonaOutputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.repository.StudentRepository;
import com.example.refactorCRUDbp.exception.NotFoundException;
import com.example.refactorCRUDbp.exception.UnprocessableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudent{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    EstAsignaturaRepository estAsignaturaRepository;

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
        Profesor profesor = profesorRepository.findById(studentInputDTO.getIdPersona()).orElse(null);
        Persona persona = personaRepository.findByIdPersona(studentInputDTO.getIdPersona());
        Student student = new Student(studentInputDTO,persona);
        if (profesor == null){
            StudentOutputDTO studentOutputDTO = new StudentOutputDTO(student);
            studentRepository.save(student);
            return studentOutputDTO;
        }else {
            throw new UnprocessableException("Error al crear estudiante");
        }


    }

    public StudentOutputDTO getStudentById(String idStudent){
        if (studentRepository.getStudentByIdStudent(idStudent) != null){
            return new StudentOutputDTO(studentRepository.getStudentByIdStudent(idStudent));
        }else {
            throw new NotFoundException("Estudiante no existe");
        }
    }

    public StudentPersonaOutputDTO getStudentPersona(String idStudent){

        if (studentRepository.getStudentByIdStudent(idStudent)!=null){
            Persona persona = personaRepository.findByIdPersona(idStudent);
            Student student = studentRepository.getStudentByIdStudent(idStudent);
            List<EstudianteAsignatura> estudianteAsignaturas = estAsignaturaRepository.findByIdStudent(idStudent);

            StudentPersonaOutputDTO studentPersonaOutputDTO = new StudentPersonaOutputDTO(new PersonaOutputDTO(persona), new StudentOutputDTO(student), estudianteAsignaturas);
            return studentPersonaOutputDTO;
        }else {
            throw new NotFoundException("Persona estudiante no exsite");
        }
    }

    public String deleteStudentById(String idStudent){
        if (studentRepository.getStudentByIdStudent(idStudent) == null){
            throw new NotFoundException("Estudiante no existe");
        }else {
            List<Student> students = studentRepository.findAll();
            Student student = studentRepository.getStudentByIdStudent(idStudent);

            for (Student s:students){
                if (s.getIdStudent().equals(idStudent)){
                    studentRepository.delete(s);
                }
            }
            return "Estudiante con id "+ idStudent + " borrado correctamente";
        }
    }

    public StudentOutputDTO updateStudent(StudentInputDTO studentInputDTO, String idStudent){
        Student student = studentRepository.getStudentByIdStudent(idStudent);
        List<Student> students = studentRepository.findAll();

        for (Student s:students){
           if (s.getIdStudent() != idStudent){
               throw new NotFoundException("Estudiante no existe");
           }else {
               if (s.getIdStudent().equals(idStudent)){
                   if (studentInputDTO.getBranch() != null){
                       student.setBranch(studentInputDTO.getBranch());
                       s.setBranch(studentInputDTO.getBranch());
                   }
                   if (studentInputDTO.getComments() != null){
                       student.setComments(studentInputDTO.getComments());
                       s.setComments(studentInputDTO.getComments());
                   }
                   if (studentInputDTO.getNumHoursWeek() != 0){
                       student.setNumHoursWeek(studentInputDTO.getNumHoursWeek());
                       s.setNumHoursWeek(studentInputDTO.getNumHoursWeek());
                   }
                   studentRepository.save(s);
               }
           }
        }
        return new StudentOutputDTO(student);
    }

}
