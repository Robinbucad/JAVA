package com.example.testSonar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PersonaEntity {

    @Id
    @GeneratedValue
    private int idPersona;
    private String name;
    private String city;

    public PersonaEntity(int id, String name, String city){
        idPersona = id;
        this.name = name;
        this.city = city;
    }

    public void updatePersona(int id, String name, String city){
        idPersona = id;
        this.name = name;
        this.city = city;
    }

    public PersonaEntity(){

    }

    public void setId(int id){
        this.idPersona = id;
    }

    public int getId(){
        return idPersona;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCity(){
        return city;
    }

}
