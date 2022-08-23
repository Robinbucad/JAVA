package com.example.refactorCRUDbp.Estudiante_asignatura.application;

import com.example.refactorCRUDbp.Estudiante_asignatura.domain.EstudianteAsignatura;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.input.EstAsignaturaInputDTO;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.output.EstAsignaturaOutputDTO;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.repository.EstAsignaturaRepository;
import com.example.refactorCRUDbp.Persona.infraestructure.repository.PersonaRepository;
import com.example.refactorCRUDbp.Profesor.domain.Profesor;
import com.example.refactorCRUDbp.Profesor.infraestructure.repository.ProfesorRepository;
import com.example.refactorCRUDbp.Student.domain.Student;
import com.example.refactorCRUDbp.Student.infraestructure.repository.StudentRepository;
import com.example.refactorCRUDbp.exception.NotFoundException;
import com.example.refactorCRUDbp.exception.UnprocessableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstAsignaturaService implements IEstAsignatura{

    @Autowired
    EstAsignaturaRepository estAsignaturaRepository;
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    ProfesorRepository profesorRepository;

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
         Student student =studentRepository.getStudentByIdStudent(estAsignaturaInputDTO.getIdStudent());
         Profesor profesor = profesorRepository.getByIdProfesor(estAsignaturaInputDTO.getIdProfesor());

         if (student == null && profesor == null){
             throw  new UnprocessableException("Error al crear asignatura");
         }

         if (estAsignaturaInputDTO.getIdProfesor() != null && estAsignaturaInputDTO.getIdStudent() != null){
             return null;
         }else if (student == null){estudianteAsignatura.setIdProfesor(profesor.getIdProfesor());
            estAsignaturaRepository.save(estudianteAsignatura);
         } else if (profesor == null){
             estudianteAsignatura.setIdStudent(student.getIdStudent());
             estAsignaturaRepository.save(estudianteAsignatura);
         }

         EstAsignaturaOutputDTO estAsignaturaOutputDTO = new EstAsignaturaOutputDTO(estudianteAsignatura);
         return estAsignaturaOutputDTO;

    }

    public EstAsignaturaOutputDTO getEstAsignaturaById(String idAsignatura){
        if (estAsignaturaRepository.findByIdAsignatura(idAsignatura) == null){
            throw  new NotFoundException("Asignatura no existe crack");
        }else {
            return  new EstAsignaturaOutputDTO(estAsignaturaRepository.findByIdAsignatura(idAsignatura));

        }
    }

    public String deleteAsignatura(String idAsignatura) {

        if (estAsignaturaRepository.findByIdAsignatura(idAsignatura) == null ){
            throw new NotFoundException("Asignatura no existe ");
        }
        else {
            List<EstudianteAsignatura> estudianteAsignaturas = estAsignaturaRepository.findAll();
            EstudianteAsignatura estAsignatura = estAsignaturaRepository.findByIdAsignatura(idAsignatura);
            for (EstudianteAsignatura e:estudianteAsignaturas){
                if (e.getIdAsignatura().equals(idAsignatura)){
                    estAsignaturaRepository.delete(e);
                }
            }
            return "Asignatura con id " + idAsignatura + " borrada correctamente";
        }
    }

    public EstAsignaturaOutputDTO updateEstudianteAsignatura(EstAsignaturaInputDTO estAsignaturaInputDTO, String idAsignatura){
        List<EstudianteAsignatura> estudianteAsignaturaList = estAsignaturaRepository.findAll();
        EstudianteAsignatura estAsignatura = estAsignaturaRepository.findByIdAsignatura(idAsignatura);

        if (estAsignatura == null){
            throw new NotFoundException("Error al encontrar la asignatura");
        }else {
            for (EstudianteAsignatura e: estudianteAsignaturaList){
                if (estAsignaturaInputDTO.getAsignatura() !=  null){
                    estAsignatura.setAsignatura(estAsignaturaInputDTO.getAsignatura());
                    e.setAsignatura(estAsignaturaInputDTO.getAsignatura());
                }

                estAsignatura.setComments(estAsignaturaInputDTO.getComments());
                e.setComments(estAsignaturaInputDTO.getComments());

                estAsignatura.setInitialDate(estAsignaturaInputDTO.getInitialDate());
                e.setInitialDate(estAsignaturaInputDTO.getInitialDate());

                estAsignatura.setFinishDate(estAsignaturaInputDTO.getFinishDate());
                e.setFinishDate(estAsignaturaInputDTO.getFinishDate());

                estAsignaturaRepository.save(e);
            }
            return new EstAsignaturaOutputDTO(estAsignatura);
        }

    }



    public boolean addSubjectStudent(String idStudent, String idAsignatura){
        EstudianteAsignatura estudianteAsignatura = estAsignaturaRepository.findByIdAsignatura(idAsignatura);
        Student student = studentRepository.findById(idStudent).orElse(null);
        student.getEstudianteAsignaturas().add(estudianteAsignatura);
        return student.getEstudianteAsignaturas().add(estudianteAsignatura);
    }
}
