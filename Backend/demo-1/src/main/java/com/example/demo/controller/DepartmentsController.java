package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Departments;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentsService;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/departments")
public class DepartmentsController {
	
	DepartmentsService departmentsService;

	
	
	@GetMapping("/search")
	public ResponseEntity<List<Departments>> searchDepts (@RequestParam ("query") String query){
		return ResponseEntity.ok(departmentsService.searchDepts(query));
	}
	
	@PostMapping("/addDepartment")
	public Departments createDepartments (@RequestBody Departments departments) {
		return departmentsService.createDepartments(departments);
	}
	
	@DeleteMapping(path = "/delete/{deptId}")
	public ResponseEntity<Boolean> deleteDepartments (@PathVariable ("deptId") Long id){
		Boolean status = departmentsService.deleteDepartments(id);
		return ResponseEntity.ok(status);
	}
	
	@PutMapping(path = "/update/{deptId}")
	public ResponseEntity<Departments> updateDepartments (@PathVariable ("deptId") Long id, @RequestBody Departments departments){
		Departments dep = departmentsService.updateDepartments(id, departments);
		return ResponseEntity.ok(dep);
	}
	

	public DepartmentsController(DepartmentsService departmentsService) {
		super();
		this.departmentsService = departmentsService;
	}
	
}
