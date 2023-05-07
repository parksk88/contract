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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;
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
@Where(clause= "deleted = false")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@NotEmpty
	@Column(nullable = false)
	private String name;
	
	private String hobby;
	
	private String address;
	
	@Valid
	@Embedded
	private Birthday birthday;
	
	private String job;
	
	private String phoneNumber;
	
	@ColumnDefault("0")
	private boolean deleted;
	
//	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
//	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
//	@ToString.Exclude
//	private Block block;
	
	public void set(PersonDto personDto) {
		
		if(!StringUtils.isEmpty(personDto.getHobby())) {
			this.setHobby(personDto.getHobby());
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
		
		if(personDto.getBirthday() != null) {
			this.setBirthday(Birthday.of(personDto.getBirthday()));
		}
	}
	
	public Integer getAge() {
		if(this.birthday != null) {
			
			return LocalDate.now().getYear() - this.birthday.getYearOfBirthday() + 1;
		} else {
			return null;
		}
	}
	
	public boolean isBirthDayToday() {
		return LocalDate.now().equals(LocalDate.of(this.birthday.getYearOfBirthday(), this.birthday.getMonthOfBirthday(), this.birthday.getDayOfBirthday()));
	}
	
}
