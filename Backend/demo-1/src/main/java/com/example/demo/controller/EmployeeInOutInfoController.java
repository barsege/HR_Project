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

import com.example.demo.entity.EmployeeInOutInfo;
import com.example.demo.entity.EmployeeInfo;
import com.example.demo.service.EmployeeInOutInfoService;
import com.example.demo.service.EmployeeInfoService;

@RestController
@RequestMapping("/employeeInOutInfo")
public class EmployeeInOutInfoController {

	private EmployeeInOutInfoService employeeInOutInfoService;
	
	
	
	public EmployeeInOutInfoController(EmployeeInOutInfoService employeeInOutInfoService) {
		super();
		this.employeeInOutInfoService = employeeInOutInfoService;
	}

	@GetMapping("/search")
	public ResponseEntity<List<EmployeeInOutInfo>> searchEmployeeInOutInfo(@RequestParam("query") String query) {
		return ResponseEntity.ok(employeeInOutInfoService.searchEmployeeInOutInfo(query));
	}

	@PostMapping
	public EmployeeInOutInfo createEmployeeInOutInfo(@RequestBody EmployeeInOutInfo employeeInOutInfo) {
		return employeeInOutInfoService.createEmployeeInOutInfo(employeeInOutInfo);
	}

	@DeleteMapping(path = "/delete/{employeeId}")
	public ResponseEntity<Boolean> deleteEmployeeInOutInfo (@PathVariable ("employeeId")	Long id){
		Boolean status = employeeInOutInfoService.deleteEmployeeInOutInfo(id);
		return ResponseEntity.ok(status);
	}
	
	@PutMapping("/update/{employeeId}")
	public ResponseEntity<EmployeeInOutInfo> updateEmployeeInOutInfo (@PathVariable ("employeeId") Long id,@RequestBody EmployeeInOutInfo employeeInfo){
		EmployeeInOutInfo eInfo =  employeeInOutInfoService.updateEmployeeInOutInfo(id,employeeInfo);
		return ResponseEntity.ok(eInfo);
	}

}
