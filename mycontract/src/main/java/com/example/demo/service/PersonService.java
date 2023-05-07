package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.controller.dto.PersonDto;
import com.example.demo.domain.Person;
import com.example.demo.domain.dto.Birthday;
import com.example.demo.repository.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	
//	public List<Person> getPeopleExcludeBlocks() {
//		List<Person> people = personRepository.findAll();
//		List<Block> blocks = blockRepository.findAll();
//		List<String> blockNames = blocks.stream().map(Block::getName).collect(Collectors.toList());
		
//		return people.stream().filter(person -> !blockNames.contains(person.getName())).collect(Collectors.toList());
//		return people.stream().filter(person -> person.getBlock() == null).collect(Collectors.toList());
//		return personRepository.findByBlockIsNull();
//		
//	}
	
	public List<Person> getPeopleByName(String name) {
//		List<Person> people = personRepository.findAll();
//		
//		return people.stream().filter(person -> person.getName().equals(name)).collect(Collectors.toList());
		return personRepository.findByName(name);
	}
	
	@Transactional(readOnly = true)
	public Person getPerson(Long id) {
//		Person person = personRepository.findById(id).get();
		Person person = personRepository.findById(id).orElse(null);
		
		log.info("person : {}", person);
		return person;
	}
	
	@Transactional
	public void put(Person person) {
		personRepository.save(person);
	}
	
	@Transactional
	public void modify(Long id, PersonDto personDto) {
		Person person = personRepository.findById(id).orElseThrow(()-> new RuntimeException("���̵� �������� �ʽ��ϴ�"));
		
		if(!person.getName().equals(personDto.getName())) {
			throw new RuntimeException("�̸��� �ٸ��ϴ�");
		}
		
		person.set(personDto);
		
		personRepository.save(person);
	}
	
	@Transactional
	public void modify(Long id, String name) {
		Person person = personRepository.findById(id).orElseThrow(() -> new RuntimeException("���̵� �������� �ʽ��ϴ�"));
		
		person.setName(name);
		
		personRepository.save(person);
	}
	
	@Transactional
	public void delete(Long id) {
		//personRepository.deleteById(id); //������ ������ �ʰ� deleted�÷����� ����ȿ������ 
		
		Person person = personRepository.findById(id).orElseThrow( () -> new RuntimeException("���̵� �������� �ʽ��ϴ�."));
		
		person.setDeleted(true);
		
		personRepository.save(person);
	}
	
}
