package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.demo.Person;


@Service
public class PersonServiceImpl implements IPersonService{

	
	private List<Person> persons;
	private IPersonService personService;
	
	@PostConstruct
	public void init() {
		this.persons=new ArrayList<>();
		 
	}
	
	@Override
	public List<Person> listAll() {
		return persons;
	}

	@Override
	public Person addPerson(Person person) {
		person.setId(persons.size()+1);
		persons.add(person);
		return person;
	}

	@Override
	public Person updatePerson(Integer id, Person person) {
		for(int i = 0; i < persons.size(); i++) {
			Person p = persons.get(i);
			if(p.getId() == id){
				person.setId(id);
				persons.set(i, person);
				return person;
			}
		}
		return null;
	}

	@Override
	public void deletePerson(Integer id) {
		/*Person p = persons.get(id);
		for(int i = 0; i<persons.size();i++) {
			if(p.getId() == id) {
				persons.remove(p);
				break;
			}
		
		}*/
		for (int i=0;i<persons.size();i++) {
			Person person=persons.get(i);
			if(person.getId() == id) {
				persons.remove(i);
				break;
			}
		}
		 
	}

}