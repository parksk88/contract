package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;

@SpringBootTest
class PersonServiceTest {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonRepository personRepository; 
	
	@Test
	void getPeopleByName() {
		List<Person> result = personService.getPeopleByName("martin");
		
		assertThat(result.size()).isEqualTo(1);
		assertThat(result.get(0).getName()).isEqualTo("martin");
	}
	
//	@Test
//	void cascadeTest() {
//		givenPeople();
//		
//		List<Person> result = personRepository.findAll();
//		
//		result.forEach(System.out::println);
//		
//		Person person = result.get(3);
//		person.getBlock().setStartDate(LocalDate.now());
//		person.getBlock().setEndDate(LocalDate.now());
//		
//		personRepository.save(person);
//		personRepository.findAll().forEach(System.out::println);
//		
////		personRepository.delete(person);
////		personRepository.findAll().forEach(System.out::println);
////		blockRepository.findAll().forEach(System.out::println);
//		
//		person.setBlock(null);
//		personRepository.save(person);
//		personRepository.findAll().forEach(System.out::println);
//		blockRepository.findAll().forEach(System.out::println);
//		
//	}
	
//	@Test
//	void getPerson() {
//		
//		Person person = personService.getPerson(3L);
//		
//		assertThat(person.getName()).isEqualTo("dennis");
//	}

}
