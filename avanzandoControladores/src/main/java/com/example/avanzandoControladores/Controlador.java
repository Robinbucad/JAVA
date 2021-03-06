package com.example.avanzandoControladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Controlador {

    @Autowired
    IUser iuser;

    @GetMapping("/ping")
    public String getPong(){
        return "pong";
    }

    @PostMapping("/user")
    IUser postUsers(@RequestBody User user){
        iuser.addUser(user);
        return iuser;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable String id){
        return iuser.getUserById(id);
    }


    @PutMapping("/user/")
    public String putMethod(@RequestParam String name){
        return "El param es "+ name;
    }


}
