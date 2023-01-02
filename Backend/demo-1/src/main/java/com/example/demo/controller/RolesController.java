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

import com.example.demo.entity.InventoryInfo;
import com.example.demo.entity.Roles;
import com.example.demo.repository.RolesRepository;
import com.example.demo.service.RolesService;

@RestController
@RequestMapping("/roles")
public class RolesController {
	private RolesService rolesService;

	public RolesController(RolesService rolesService) {
		super();
		this.rolesService = rolesService;
	}
	
	@GetMapping(path = "/search")
	public ResponseEntity<List<Roles>> searchRoles(@RequestParam ("query")String query){
		return ResponseEntity.ok(rolesService.searchRoles(query));
	}
	
	@PostMapping
	public Roles createRoles(@RequestBody Roles roles) {
		return rolesService.createRoles(roles);
	}
	
	@PutMapping(path = "/update/{roleId}")
	public ResponseEntity<Roles> updateRoles(@PathVariable ("roleId") Long id, @RequestBody Roles info){
		Roles rInfo = rolesService.updateRoles(id, info);
		return ResponseEntity.ok(rInfo);
	}
	
	@DeleteMapping(path = "/delete/{roleId}")
	public ResponseEntity<Boolean> deleteRoles(@PathVariable ("roleId") Long id){
		Boolean status = rolesService.deleteRoles(id);
		return ResponseEntity.ok(status);
	}
}
