package com.coderscampus.Unit15.servic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.Unit15.domain.Person;
import com.coderscampus.Unit15.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepo;
	Integer counter=1;
	
	public Person savePerson(Person person) {
		if (person.getID() == null)
		person.setID(counter++);
		return  personRepo.save(person);
	}
	
	public Person findById(Integer personId) {
		return personRepo.findByID(personId);
		
	}

	public List<Person> findAll() {
		
		return personRepo.findAll();
	}

	public void delete(Integer personid) {
		personRepo.delete(personid);
		
	}
	
}
