package com.example.demo.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.entity.EmployeeInventoryInfo;
import com.example.demo.entity.InventoryInfo;
import com.example.demo.service.EmployeeInventoryInfoService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/employeeInventoryInfo")
public class EmployeeInventoryInfoController {

	@Autowired
	private EmployeeInventoryInfoService employeeInventoryInfoService;

	public EmployeeInventoryInfoController(EmployeeInventoryInfoService employeeInventoryInfoService) {
		super();
		this.employeeInventoryInfoService = employeeInventoryInfoService;
	}
	
	@GetMapping(path = "/searchAll")
	public ResponseEntity<List<EmployeeInventoryInfo>> searchEmployeeInventoryInfo (@RequestParam ("query") String query){
		
		return ResponseEntity.ok(employeeInventoryInfoService.searchEmployeeInventoryInfo(query));
	}
	
	@GetMapping("/searchId/{id}")
	public ResponseEntity<List<InventoryInfo>> findByIdEmployeeInventoryInfo (@PathVariable ("id") Long id){
		List <InventoryInfo> employeeInfo = employeeInventoryInfoService.findByIdEmployeeInventoryInfo(id);
		
		return ResponseEntity.ok(employeeInfo);
		
	}
	
	@GetMapping("/unassignedInv")
	public ResponseEntity<List<InventoryInfo>> getUnassignedInventory (@RequestParam ("query") String query){
		List <InventoryInfo> employeeInfo = employeeInventoryInfoService.getUnassignedInventory(query);
		
		return ResponseEntity.ok(employeeInfo);	
	}
	
	@PostMapping
	public EmployeeInventoryInfo createEmployeeInventoryInfo (@RequestBody EmployeeInventoryInfo employeeInventoryInfo) {
		return employeeInventoryInfoService.createEmployeeInventoryInfo(employeeInventoryInfo);
	}
	
	@PostMapping("/assign/{recievingEmpId}/{inventoryId}")
	public EmployeeInventoryInfo assignInventory (@PathVariable ("recievingEmpId")Long empId,@PathVariable("inventoryId") Long invId) {
		return employeeInventoryInfoService.assignInventory(empId, invId);
	}
	
	@DeleteMapping(path = "/delete/{recievingEmpId}")
	public ResponseEntity<Boolean> deleteEmployeeInventoryInfo (@PathVariable ("recievingEmpId")Long id){
		Boolean status = employeeInventoryInfoService.deleteEmployeeInventoryInfo(id);
		
		return ResponseEntity.ok(status);
	}
	
	@PutMapping (path = "/update/{recievingEmpId}")
	public ResponseEntity<EmployeeInventoryInfo> updateEmployeeInventoryInfo (@PathVariable ("recievingEmpId") Long id, @RequestBody EmployeeInventoryInfo employeeInventoryInfo){
		EmployeeInventoryInfo eIInfo = employeeInventoryInfoService.updateEmployeeInventoryInfo(id, employeeInventoryInfo);
		
		return ResponseEntity.ok(eIInfo);
	}
	
	
}
