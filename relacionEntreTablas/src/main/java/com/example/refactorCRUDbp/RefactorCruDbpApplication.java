package com.example.refactorCRUDbp;

import com.example.refactorCRUDbp.Persona.application.PersonaService;
import com.example.refactorCRUDbp.Persona.domain.Persona;
import com.example.refactorCRUDbp.Persona.domain.Roles;
import com.example.refactorCRUDbp.Persona.infraestructure.controler.input.PersonaInputDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class RefactorCruDbpApplication {


	public static void main(String[] args) {
		SpringApplication.run(RefactorCruDbpApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(PersonaService personaService){
		return args -> {
			personaService.saveRole(new Roles(null,"ADMIN"));

			personaService.createUser(new PersonaInputDTO(
					"robinbuc",
					"123",
					"robin",
					"bucad villanueva",
					"robin.bucad6@bosonit.com",
					"robin.bucad6@gmail.com",
					"alicante",
					true,
					new Date((long) (2000-27.04)),
					new Date((long) (2000-27.04)),
					"unaimagen",
					new ArrayList<>()
			));


			personaService.addRoleToUser("robinbuc","ADMIN");

		};
	}

}
