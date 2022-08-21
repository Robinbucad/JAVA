package com.example.CRUDvalidation;

import lombok.Data;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CruDvalidationApplicationTests {

	@Autowired
	PersonaRepository personaRepository;


	PersonaInputDTO personaInputDTO = new PersonaInputDTO(
			"RobinBuca",
			"Robin",
			"contraseña",
			"bucad",
			"robin.bosonit@gmail.com",
			"robin.bucad@gmail.com",
			"alicante",
			true,
			"imagen",
			new Date(2020-03-20),
			new Date(2020-03-20)
	);

	PersonaInputDTO updatedPersona = new PersonaInputDTO(
			"OtraPers",
			"Otra",
			"contraseña",
			"bucad",
			"robin.bosonit@gmail.com",
			"robin.bucad@gmail.com",
			"china",
			true,
			"imagen",
			new Date(2020-03-20),
			new Date(2020-03-20)
	);
	@Test
	@Order(1)
	public void createPerson(){
		PersonaEntity persona = new PersonaEntity(personaInputDTO);
		personaRepository.save(persona);
		Assertions.assertEquals("alicante", persona.getCity());
	}

	@Test
	@Order(2)
	public void getAllPersons(){
		List<PersonaEntity> persona= personaRepository.findAll();
		Assertions.assertEquals(1,persona.size());
	}

	@Test
	@Order(3)
	public void getPersonById(){
		PersonaOutputDTO persona = personaRepository.findByIdPersona(1);
		Assertions.assertEquals(1, persona.idPersona());
	}

	@Test
	@Order(4)
	public void updatePersona(){
		PersonaEntity persona = personaRepository.findById(1).orElseThrow();
		persona.updatePersona(updatedPersona);
		personaRepository.save(persona);

		Assertions.assertEquals("china", persona.getCity());

	}

	@Test
	@Order(5)
	public void deletePersona(){
		PersonaEntity persona = personaRepository.findById(1).orElseThrow();
		personaRepository.delete(persona);
		PersonaOutputDTO personaOutputDTO = personaRepository.findByIdPersona(1);
		Assertions.assertEquals(null,personaOutputDTO);
	}


}
