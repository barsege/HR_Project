package com.example.demo.service;

import java.util.List;

import com.example.demo.Person;

public interface IPersonService   {

	
	List<Person> listAll();
	
	Person addPerson(Person person);
	
	Person updatePerson(Integer id,Person person);
	
	void deletePerson(Integer id);
}