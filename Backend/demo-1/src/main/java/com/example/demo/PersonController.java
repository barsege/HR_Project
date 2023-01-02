package com.example.demo;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IPersonService;

@RestController
public class PersonController {

	
	@Autowired
	private IPersonService personService;
	
	@GetMapping(path = "/persons")
	public List<Person> studentInfo() {
		return personService.listAll();
	}
	
	@PostMapping(path ="/persons" )
	public Person addPerson(@RequestBody Person person) {
		return personService.addPerson(person);
	}
	
	@DeleteMapping(path ="/persons/{id}")
	public void deletePerson(@PathVariable(name = "id") int id) {
		personService.deletePerson(id);
	}
	
	@PutMapping(path = "/persons/{id}")
	public Person updatePerson(@PathVariable (name = "id")int id, @RequestBody Person person) {
		return personService.updatePerson(id, person);
	}
	
}