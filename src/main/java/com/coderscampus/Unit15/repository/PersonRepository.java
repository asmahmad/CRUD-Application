package com.coderscampus.Unit15.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.coderscampus.Unit15.domain.Person;

@Repository
public class PersonRepository {
	
	private Map<Integer,Person> people = new HashMap<>();
	
	public Person save(Person person) {
		
		people.put(person.getID(), person);
		return person;
	}
	
	public Person findByID (Integer personID) {
		
		
		return people.get(personID);
		
	}

	public List<Person> findAll() {
			
		return 	people.entrySet()
				       .stream()
				       .map(entry -> entry.getValue())
				       .collect(Collectors.toList());
	}

	public void delete(Integer personid) {
		people.remove(personid);
		
	}
}
