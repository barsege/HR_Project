package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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

import com.example.demo.entity.EmployeeInfo;
import com.example.demo.service.EmployeeInfoService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/employee_info")
public class EmployeeInfoController {

	private EmployeeInfoService employeeInfoService;

	public EmployeeInfoController(EmployeeInfoService employeeInfoService) {
		super();
		this.employeeInfoService = employeeInfoService;
	}

	@GetMapping("/searchAll")
	public ResponseEntity<List<EmployeeInfo>> searchEmpInfo(@RequestParam("query") String query) {
		return ResponseEntity.ok(employeeInfoService.searchEmployeeInfo(query));
	}
	
	@GetMapping("/searchId/{id}")
	public ResponseEntity<EmployeeInfo> getEmpById (@PathVariable ("id") Long id){
		EmployeeInfo employeeInfo = employeeInfoService.getEmpById(id);
		
		return ResponseEntity.ok(employeeInfo);
		
	}

	@PostMapping("/addEmployee")
	public EmployeeInfo createEmployeeInfo(@RequestBody EmployeeInfo employeeInfo) {
		return employeeInfoService.createEmployeeInfo(employeeInfo);
	}
	
	@DeleteMapping(path = "/delete/{employeeId}")
	public ResponseEntity<Boolean> deleteEmployeeInfo (@PathVariable ("employeeId")	Long id){
		Boolean status = employeeInfoService.deleteEmployeeInfo(id);
		return ResponseEntity.ok(status);
	}
	
	@PutMapping("/update/{employeeId}")
	public ResponseEntity<EmployeeInfo> updateEmployeeInfo (@PathVariable ("employeeId") Long id,@RequestBody EmployeeInfo employeeInfo){
		EmployeeInfo eInfo =  employeeInfoService.updateEmployeeInfo(id,employeeInfo);
		return ResponseEntity.ok(eInfo);
	}
}
