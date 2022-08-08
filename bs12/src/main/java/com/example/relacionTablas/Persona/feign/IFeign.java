package com.example.relacionTablas.Persona.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "feign", url = "http://localhost:8080/profesor/")
public interface IFeign {

    @GetMapping("/{id}")
    ResponseEntity<Object> getProfesor(@PathVariable String id);

}
