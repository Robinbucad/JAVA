package com.example.relacionTablas.Student.application;


import com.example.relacionTablas.Persona.domain.Persona;
import com.example.relacionTablas.Persona.infraestrucure.controller.output.PersonaOutputDto;
import com.example.relacionTablas.Persona.infraestrucure.repository.PersonaRepository;
import com.example.relacionTablas.Profesor.domain.Profesor;
import com.example.relacionTablas.Profesor.infraestructure.repository.ProfesorRepository;
import com.example.relacionTablas.Student.domain.Student;
import com.example.relacionTablas.Student.infraestructure.controller.input.StudentInputDto;
import com.example.relacionTablas.Student.infraestructure.controller.output.FullStudentOutputDto;
import com.example.relacionTablas.Student.infraestructure.controller.output.StudentOutputDto;
import com.example.relacionTablas.Student.infraestructure.repository.StudentRepository;
import com.example.relacionTablas.StudentAsignatura.domain.StudentAsignatura;
import com.example.relacionTablas.StudentAsignatura.infraestructure.controller.output.StudentAsignaturaOutputDto;
import com.example.relacionTablas.StudentAsignatura.infraestructure.repository.StudentAsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IEstudent{

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    StudentAsignaturaRepository studentAsignaturaRepository;

    public List<StudentOutputDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        List<StudentOutputDto> studentOutputDto = new ArrayList<>();

        for (Student s:students){
            StudentOutputDto createStudent = new StudentOutputDto(s);
            studentOutputDto.add(createStudent);
        }
        return studentOutputDto;
    }

    public StudentOutputDto createStudent(StudentInputDto studentInputDto){
        Persona persona = personaRepository.findByIdPersona(studentInputDto.getIdPersona());
        Student student = new Student(studentInputDto, persona);
        studentRepository.save(student);
        StudentOutputDto studentOutputDto = new StudentOutputDto(student);
        return studentOutputDto;
    }

    public StudentOutputDto findStudentById(String idStudent){
        return studentRepository.findStudentByIdStudent(idStudent);
    }

    public FullStudentOutputDto findFullStudentById(String idStudent){
        PersonaOutputDto persona = personaRepository.findPersonaByIdPersona(idStudent);
        StudentOutputDto student = studentRepository.findStudentByIdStudent(idStudent);

        FullStudentOutputDto fullStudent = new FullStudentOutputDto(student,persona);
        return fullStudent;
    }

    public StudentOutputDto updateStudent(String idStudent, StudentInputDto student){
        Student studentUpdate = studentRepository.findByIdStudent(idStudent);
        studentUpdate.update(student);
        studentRepository.save(studentUpdate);
        return new StudentOutputDto(studentUpdate);
    }

    public String deleteStudent(String idStudent){
        List<Student> studentList = studentRepository.findAll();
        for (Student s:studentList){
            if (s.getIdStudent().equals(idStudent)){
                studentRepository.delete(s);
            }
        }
        return "Estudiante con id "+ idStudent + " borrado correctamente";
    }

    public List<StudentAsignaturaOutputDto> getAsignaturasStudent(String idStudent){
        List<StudentAsignatura> studentAsignaturaList = studentAsignaturaRepository.findStudentAsignaturaByStudentList(idStudent);
        List<StudentAsignaturaOutputDto> asignaturaListOutput = new ArrayList<>();

        for (StudentAsignatura s:studentAsignaturaList ){
            StudentAsignaturaOutputDto studentAsignaturaOutputDto = new StudentAsignaturaOutputDto(s);
            asignaturaListOutput.add(studentAsignaturaOutputDto);
        }
        return asignaturaListOutput;
    }

}
