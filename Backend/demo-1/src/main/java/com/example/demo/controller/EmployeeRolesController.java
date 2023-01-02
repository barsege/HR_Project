package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EmployeeRoles;
import com.example.demo.entity.InventoryInfo;
import com.example.demo.service.EmployeeRolesService;

@RestController
@RequestMapping("/employeeRoles")
public class EmployeeRolesController {

	private EmployeeRolesService employeeRolesService;

	public EmployeeRolesController(EmployeeRolesService employeeRolesService) {
		super();
		this.employeeRolesService = employeeRolesService;
	}
	
	@GetMapping(path = "/search")
	public ResponseEntity<List<EmployeeRoles>> searchInventoryInfo (@RequestParam ("query") String query){
		
		return ResponseEntity.ok(employeeRolesService.searchEmployeeRoles(query));
	}
	
	@PostMapping
	public EmployeeRoles createEmployeeRoles (@RequestBody EmployeeRoles employeeRoles) {
		return employeeRolesService.createEmployeeRoles(employeeRoles);
	}
	
	@DeleteMapping(path = "/delete/{roleId}")
	public ResponseEntity<Boolean> deleteEmployeeRoles(@PathVariable ("roleId") Long id){
		Boolean status = employeeRolesService.deleteEmployeeRoles(id);
		return ResponseEntity.ok(status);		
	}
	
	@PutMapping (path = "/update/{roleId}")
	public ResponseEntity<EmployeeRoles> updateEmployeeRoles (@PathVariable ("roleId") Long id, @RequestBody EmployeeRoles employeeRoles){
		EmployeeRoles eRoles = employeeRolesService.updateEmployeeRoles(id, employeeRoles);
		return ResponseEntity.ok(eRoles);
	}
}
