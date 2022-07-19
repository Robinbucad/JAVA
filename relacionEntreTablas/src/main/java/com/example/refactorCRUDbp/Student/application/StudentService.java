package com.example.refactorCRUDbp.Student.application;

import com.example.refactorCRUDbp.Student.domain.Student;
import com.example.refactorCRUDbp.Student.infraestructure.controller.input.StudentInputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentOutputDTO;
import com.example.refactorCRUDbp.Student.infraestructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudent{

    @Autowired
    StudentRepository studentRepository;

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

}
