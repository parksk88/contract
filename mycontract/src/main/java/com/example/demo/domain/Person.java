package com.example.demo.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.util.StringUtils;

import com.example.demo.controller.dto.PersonDto;
import com.example.demo.domain.dto.Birthday;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@NotEmpty
	@Column(nullable = false)
	private String name;
	
	@NonNull
	private int age;
	
	private String hobby;
	
	@NotEmpty
	@NonNull
	@Column(nullable = false)
	private String bloodType;
	
	private String address;
	
	@Valid
	@Embedded
	private Birthday birthday;
	
	private String job;
	
	@ToString.Exclude
	private String phoneNumber;
	
	private boolean deleted;
	
//	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@ToString.Exclude
	private Block block;
	
	public void set(PersonDto personDto) {
		if(personDto.getAge() != 0) {
			this.setAge(personDto.getAge());
		}
		
		if(!StringUtils.isEmpty(personDto.getHobby())) {
			this.setHobby(personDto.getHobby());
		}
		
		if(!StringUtils.isEmpty(personDto.getBloodType())) {
			this.setBloodType(personDto.getBloodType());
		}
		
		if(!StringUtils.isEmpty(personDto.getAddress())) {
			this.setAddress(personDto.getAddress());
		}
		
		if(!StringUtils.isEmpty(personDto.getJob())) {
			this.setJob(personDto.getJob());
		}
		
		if(!StringUtils.isEmpty(personDto.getPhoneNumber())) {
			this.setPhoneNumber(personDto.getPhoneNumber());
		}
	}
	
}
