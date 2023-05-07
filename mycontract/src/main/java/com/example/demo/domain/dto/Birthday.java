package com.example.demo.domain.dto;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Birthday {
	
	private Integer yearOfBirthday; 
	private Integer monthOfBirthday;
	private Integer dayOfBirthday;
	
	private Birthday(LocalDate birthday) {
		this.yearOfBirthday = birthday.getYear();
		this.monthOfBirthday = birthday.getMonthValue();
		this.dayOfBirthday = birthday.getDayOfMonth();
	}
	
	public static Birthday of(LocalDate birthday) {
		return new Birthday(birthday);
	}
}
