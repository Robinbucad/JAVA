package com.example.relacionTablas.Profesor.domain;

import com.example.relacionTablas.Persona.domain.Persona;
import com.example.relacionTablas.Profesor.infraestructure.controller.input.ProfesorInputDto;
import com.example.relacionTablas.SequenceIdGenerator.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prof")
    @GenericGenerator(
            name = "prof",
            strategy = "com.example.relacionTablas.SequenceIdGenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            }
    )
    private String idProfesor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    private String comments;
    private String branch;

    public Profesor(ProfesorInputDto profesor, Persona persona){
        setBranch(profesor.getBranch());
        setComments(profesor.getComments());
        this.persona = persona;
    }



    public Profesor(){}
}
