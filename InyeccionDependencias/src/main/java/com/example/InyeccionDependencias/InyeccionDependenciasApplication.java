package com.example.InyeccionDependencias;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InyeccionDependenciasApplication {

	public static void main(String[] args) {
		SpringApplication.run(InyeccionDependenciasApplication.class, args);
	}

	@Bean
	@Qualifier("persona1")
	public PersonaInt getPersona1(){
		PersonaInt persona1 = new PersonaImpl();
		persona1.setNombre("Robin");
		persona1.setPoblacion("San Vicente");
		persona1.setEdad("22");
		return persona1;
	}

	@Bean
	@Qualifier("persona2")
	public PersonaInt getPersona2(){
		PersonaInt persona2 = new PersonaImpl();
		persona2.setNombre("Ana");
		persona2.setPoblacion("Alicante");
		persona2.setEdad("25");
		return persona2;
	}

	@Bean
	@Qualifier("persona3")
	public PersonaInt getPersona3(){
		PersonaInt persona3 = new PersonaImpl();
		persona3.setNombre("Jacob");
		persona3.setPoblacion("Guardamar");
		persona3.setEdad("28");
		return persona3;
	}

	@Bean
	@Qualifier("notFound")
	public PersonaInt notFound(){
		PersonaInt notFound = new PersonaImpl();
		notFound.setNombre("Desconocida");
		notFound.setPoblacion("Desconocida");
		notFound.setEdad("Desconocida");
		return notFound;
	}

}


