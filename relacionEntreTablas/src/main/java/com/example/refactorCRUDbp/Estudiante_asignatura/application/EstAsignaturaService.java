package com.example.refactorCRUDbp.Estudiante_asignatura.application;

import com.example.refactorCRUDbp.Estudiante_asignatura.domain.EstudianteAsignatura;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.input.EstAsignaturaInputDTO;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.Controller.output.EstAsignaturaOutputDTO;
import com.example.refactorCRUDbp.Estudiante_asignatura.infraestructure.repository.EstAsignaturaRepository;
import com.example.refactorCRUDbp.Student.application.StudentService;
import com.example.refactorCRUDbp.Student.infraestructure.controller.output.StudentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstAsignaturaService implements IEstAsignatura{

    @Autowired
    EstAsignaturaRepository estAsignaturaRepository;

    @Autowired
    StudentService studentService;

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

    public List<EstAsignaturaOutputDTO> getEstAsignaturaById(String idAsignatura)throws Exception{
        List<EstudianteAsignatura> estudianteAsignatura = estAsignaturaRepository.findAll();
        List<EstAsignaturaOutputDTO> estAsignaturaOutputDTOList = new ArrayList<>();

        for (EstudianteAsignatura e:estudianteAsignatura){
            if (e.getIdStudent().equals(idAsignatura)){
                EstAsignaturaOutputDTO estAsign = new EstAsignaturaOutputDTO(e);
                estAsignaturaOutputDTOList.add(estAsign);
            }

        }
        return estAsignaturaOutputDTOList;    }

    public EstAsignaturaOutputDTO deleteAsignatura(String idAsignatura) throws Exception {

        if (estAsignaturaRepository.findByIdAsignatura(idAsignatura) == null ){
            throw new Exception();
        }

        else {
            List<EstudianteAsignatura> estudianteAsignaturas = estAsignaturaRepository.findAll();
            EstAsignaturaOutputDTO estAsignaturaOutputDTO = estAsignaturaRepository.findByIdAsignatura(idAsignatura);
            for (EstudianteAsignatura e:estudianteAsignaturas){
                if (e.getIdAsignatura().equals(idAsignatura)){
                    estAsignaturaRepository.delete(e);
                }
            }
            return estAsignaturaOutputDTO;
        }

    }

    public EstAsignaturaOutputDTO updateEstudianteAsignatura(EstAsignaturaInputDTO estAsignaturaInputDTO, String idAsignatura){
        List<EstudianteAsignatura> estudianteAsignaturaList = estAsignaturaRepository.findAll();
        EstAsignaturaOutputDTO estAsignaturaOutputDTO = estAsignaturaRepository.findByIdAsignatura(idAsignatura);

        for (EstudianteAsignatura e: estudianteAsignaturaList){
            if (estAsignaturaInputDTO.getAsignatura() !=  null){
                estAsignaturaOutputDTO.setAsignatura(estAsignaturaInputDTO.getAsignatura());
                e.setAsignatura(estAsignaturaInputDTO.getAsignatura());
            }

            estAsignaturaOutputDTO.setComments(estAsignaturaInputDTO.getComments());
            e.setComments(estAsignaturaInputDTO.getComments());

            estAsignaturaOutputDTO.setInitialDate(estAsignaturaInputDTO.getInitialDate());
            e.setInitialDate(estAsignaturaInputDTO.getInitialDate());

            estAsignaturaOutputDTO.setFinishDate(estAsignaturaInputDTO.getFinishDate());
            e.setFinishDate(estAsignaturaInputDTO.getFinishDate());

            estAsignaturaRepository.save(e);
        }

        return estAsignaturaOutputDTO;
    }

    public EstAsignaturaOutputDTO getStudentById(String idStudent) throws Exception{
       StudentOutputDTO student = studentService.getStudentById(idStudent);

       System.out.println(student);

       return null;
    }

}
