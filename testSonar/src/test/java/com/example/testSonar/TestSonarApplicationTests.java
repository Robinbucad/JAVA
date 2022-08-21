package com.example.testSonar;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestSonarApplicationTests {

	@Autowired
	PersonaRepository personaRepository;


	@Test
	@Order(1)
	public void createPersona(){
		PersonaEntity persona = new PersonaEntity(1,"Robin", "alicante");
		personaRepository.save(persona);
		Assertions.assertEquals("alicante", persona.getCity());
	}

	@Test
	@Order(2)
	public void findPersonaById(){
		PersonaEntity persona = personaRepository.findById(1).orElseThrow();
		Assertions.assertEquals(1,persona.getId());
	}

	@Test
	@Order(3)
	public void getAllPersonas(){
		List<PersonaEntity> personaEntities = personaRepository.findAll();
		Assertions.assertEquals(1, personaEntities.size());
	}

	@Test
	@Order(4)
	public void updatePersona(){
		PersonaEntity persona = personaRepository.findById(1).orElseThrow();
		persona.updatePersona(1,"Robin","valencia");
		personaRepository.save(persona);
		Assertions.assertEquals("valencia",persona.getCity());

	}

	@Test()
	@Order(5)
	public void setters(){
		PersonaEntity persona = personaRepository.findById(1).orElseThrow();

		persona.setId(2);
		Assertions.assertEquals(2, persona.getId());

		persona.setCity("china");
		Assertions.assertEquals("china", persona.getCity());

		persona.setName("paco");
		Assertions.assertEquals("paco", persona.getName());

	}

	@Test
	@Order(6)
	public void deletePersona(){
		PersonaEntity persona = personaRepository.findById(1).orElseThrow();
		personaRepository.delete(persona);
		Optional<PersonaEntity> personaEntity = personaRepository.findById(1);
		Assertions.assertEquals(Optional.empty(), personaEntity);
	}

	@Test
	@Order(6)
	public void main() {
		TestSonarApplication.main(new String[] {});
	}

}
