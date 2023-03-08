package com.coderscampus.Unit15.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.Unit15.domain.Person;
import com.coderscampus.Unit15.servic.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	PersonService personservice;
	
	@GetMapping("/persons")
	public String getPeople(ModelMap model) {
		List<Person> people = personservice.findAll();
		Person person = new Person();
		
		model.put("person", person);
		model.put("people", people);
		
		return "people";
	}
	
	@GetMapping("/persons/{personId}")
	public String getPerson(@PathVariable Integer personId, ModelMap model) {
		Person person = personservice.findById(personId);
		model.put("person",person);
		return "people";		
	}
	
	@PostMapping("/persons")
	public String postPeople(Person person) {
		Person savedPerson = personservice.savePerson(person);
		System.out.println(savedPerson);
		return "redirect:/persons";
	}
	
	@PostMapping("/persons/{personId}")
	
	public String postPerson(Person person) {
		Person savedPerson = personservice.savePerson(person);
		System.out.println(savedPerson);
		return "redirect:/persons/" + savedPerson.getID();
		
	}

	@PostMapping("/persons/{personId}/delete")
	public String deletePerson(@PathVariable Integer personId) {
		System.out.println("Inside delete");
		
		personservice.delete(personId);
		return "redirect:/persons";
	}
}
