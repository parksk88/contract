package com.example.demo.configuration.serializer;

import java.io.IOException;
import java.time.LocalDate;

import com.example.demo.domain.dto.Birthday;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class BirthdaySerializer extends JsonSerializer<Birthday>{
	
	@Override
	public void serialize(Birthday value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		if (value != null ) {
			
			gen.writeObject(LocalDate.of(value.getYearOfBirthday(), value.getMonthOfBirthday(), value.getDayOfBirthday()));
		}
	}
}
