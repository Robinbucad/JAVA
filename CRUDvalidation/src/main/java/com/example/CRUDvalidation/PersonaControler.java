package com.example.CRUDvalidation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonaControler {

    @Autowired
    PersonaService personaService;

   @GetMapping
    public String getPing(){
       return "pong";
   }

   @GetMapping("/users")
    public List<PersonaOutputDTO> getAllPersonas(@RequestParam int page){
       return personaService.getAllPersonas(page);
   }

    @GetMapping("/criteria")
    public List<PersonaOutputDTO> getPersonWithCriteria(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<Date> creation_date,
            @RequestParam(defaultValue = "mayor") String condition
    ){
        return personaService.getPersonasCriteria(creation_date,condition);
    }


    @PostMapping("/users")
    public PersonaOutputDTO addUser(@RequestBody PersonaInputDTO personaInputDTO)throws Exception{
       return personaService.addUser(personaInputDTO);
   }

    @GetMapping("/users/{usuario}")
    public PersonaOutputDTO findByUsername(@PathVariable String usuario) throws Exception{
       return personaService.findByUsername(usuario);
    }

    @GetMapping("/users/id/{idPersona}")
    public PersonaOutputDTO findByID(@PathVariable int idPersona)throws Exception{
       return personaService.findByIdPersona(idPersona);
    }

}
