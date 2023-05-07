package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
	List<Person> findByName(String name);
	
//	@Query(value = "select person from Person person where person.birthday.monthOfBirthday = ?1 and person.birthday.dayOfBirthday = ?2")
//	List<Person> findByMonthOfBirthday(int monthOfBirthday, int dayOfBirthday );
	
	@Query(value = "select person from Person person where person.birthday.monthOfBirthday = :monthOfBirthday")
	List<Person> findByMonthOfBirthday(@Param("monthOfBirthday") int monthOfBirthday);
	
//	@Query(value = "select * from person where month_of_birthday = :monthOfBirthday and day_of_birthday = :dayOfBirthday", nativeQuery = true)
//	List<Person> findByMonthOfBirthday(@Param("monthOfBirthday") int monthOfBirthday, @Param("dayOfBirthday") int dayOfBirthday );
	
	@Query(value = "select * from Person person where person.deleted = true", nativeQuery = true)
	List<Person> findPeopleDeleted();
	
	
}
