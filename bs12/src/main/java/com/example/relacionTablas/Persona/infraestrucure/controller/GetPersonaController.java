package com.example.relacionTablas.Persona.infraestrucure.controller;


import com.example.relacionTablas.Persona.application.PersonaService;
import com.example.relacionTablas.Persona.domain.Persona;
import com.example.relacionTablas.Persona.feign.IFeign;
import com.example.relacionTablas.Persona.infraestrucure.controller.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = RequestMethod.GET)
public class GetPersonaController {

    @Autowired
    PersonaService personaService;

    @Autowired
    IFeign iFeign;

    @GetMapping("/ping")
    public String getPong(){
        return "pong";
    }

    @GetMapping("/persona")
    public ResponseEntity<Object> getAllPersonas(){
        try {
            List<PersonaOutputDto> personaOutputDtoList = personaService.getAllPersonas();
            return new ResponseEntity<>(personaOutputDtoList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error al traer la lista", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<Object> findPersonaById(@PathVariable String id)throws Exception {
        try {
            PersonaOutputDto personaOutputDto = personaService.findPersonaById(id);
            return new ResponseEntity<>(personaOutputDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al encontrar la persona", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/feign/{id}")
    ResponseEntity<Object> callUsingFeign(@PathVariable String id) throws Exception{
            ResponseEntity<PersonaOutputDto> rs = new RestTemplate().getForEntity("http://localhost:8081/persona/"+id, PersonaOutputDto.class);
            return ResponseEntity.ok(rs.getBody());

    }

    @GetMapping("/feign/teacher/{id}")
    public ResponseEntity<Object> getProfesorFeign(@PathVariable String id){
        return iFeign.getProfesor(id);
    }

}
