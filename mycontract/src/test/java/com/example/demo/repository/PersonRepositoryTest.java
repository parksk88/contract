package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Person;
import com.example.demo.domain.dto.Birthday;

@SpringBootTest
class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;
	
//	@Test
//	void crud() {
//		Person person = new Person();
//		person.setName("john");
//		person.setAge(10);
//		person.setBloodType("A");
//		
//		personRepository.save(person);
//		System.out.println(personRepository.findAll());
//		 
//		List<Person> result = personRepository.findByName("john");
//		
//		assertThat(result.size()).isEqualTo(1);
//		assertThat(result.get(0).getName()).isEqualTo("john");
//		assertThat(result.get(0).getAge()).isEqualTo(10);
//		assertThat(result.get(0).getBloodType()).isEqualTo("A");
//		
//		//personRepository.deleteAll();
//	}
	
//	@Test
//	void hashCodeAndEquals() {
//		Person person1 = new Person("walter", 10, "A");
//		Person person2 = new Person("walter", 10, "B");
//		
//		System.out.println(person1.equals(person2));
//		System.out.println(person1.hashCode());
//		System.out.println(person2.hashCode());
//		
//		Map<Person,Integer> map = new HashMap<>();
//		map.put(person1, person1.getAge());
//		
//		System.out.println(map);
//		System.out.println(map.get(person2));
//	}
	
	@Test
	void findByBloodType() {
		
		List<Person> result = personRepository.findByBloodType("A");
//		result.forEach(System.out::println);
		assertThat(result.size()).isEqualTo(2);
		assertThat(result.get(0).getName()).isEqualTo("martin");
		assertThat(result.get(1).getName()).isEqualTo("benny");
	}
	
	@Test
	void findByBirthdayBetween() {
		
		List<Person> result = personRepository.findByMonthOfBirthday(8);
		
		assertThat(result.size()).isEqualTo(2);
		assertThat(result.get(0).getName()).isEqualTo("martin");
		assertThat(result.get(1).getName()).isEqualTo("sophia");
	}
	
//	private void givenPerson(String name, int age, String bloodType ) {
//		givenPerson(name, age, bloodType, null);
//		
//	}
//	
//	private void givenPerson(String name, int age, String bloodType, LocalDate birthday) {
//		Person person =new Person(name, age, bloodType);
//		person.setBirthday(new Birthday(birthday));
//		personRepository.save(person);
//	}

}
