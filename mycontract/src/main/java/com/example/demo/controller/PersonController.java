package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dto.PersonDto;
import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping(value = "/api/person")
@RestController
@Slf4j
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("/{id}")
	public Person getPerson(@PathVariable Long id) {
		return personService.getPerson(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void postPerson(@RequestBody Person person) {
		personService.put(person);
	}
	
	@PutMapping("/{id}")
	public void modifyPerson(@PathVariable Long id, @RequestBody PersonDto personDto) {
		personService.modify(id, personDto);
	}
	
	@PatchMapping("/{id}")
	public void modifyPerson(@PathVariable Long id, String name) {
		personService.modify(id, name);
	}
	
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable Long id) {
		personService.delete(id);
		
//		return personRepository.findPeopleDeleted().stream().anyMatch(person -> person.getId().equals(id));
	}
	
}
