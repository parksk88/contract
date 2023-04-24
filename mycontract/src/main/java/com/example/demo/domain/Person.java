package com.example.demo.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
@Getter
@Setter
@RequiredArgsConstructor
@Data
public class Person {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NonNull
	private String name;
	
	@NonNull
	private int age;
	
	private String hobby;
	
	@NonNull
	private String bloodType;
	private String address;
	private LocalTime birthday;
	private String job;
	
	@ToString.Exclude
	private String phoneNumber;
	
//	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@ToString.Exclude
	private Block block;
	
}
