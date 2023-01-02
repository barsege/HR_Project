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

import com.example.demo.entity.Roles;
import com.example.demo.entity.TypeParameter;
import com.example.demo.service.TypeParameterService;

@RestController
@RequestMapping("/typeParameter")
public class TypeParameterController {

	private TypeParameterService parameterService;

	public TypeParameterController(TypeParameterService parameterService) {
		super();
		this.parameterService = parameterService;
	}
	
	@GetMapping(path = "/search")
	public ResponseEntity<List<TypeParameter>> searchTypeParameter(@RequestParam ("query")String query){
		return ResponseEntity.ok(parameterService.searchTypeParameter(query));
	}
	
	@PostMapping
	public TypeParameter createTypeParameter(@RequestBody TypeParameter typeParameter) {
		return parameterService.createTypeParameter(typeParameter);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Boolean> deleteTypeParameter (@PathVariable ("id") Long id ){
		Boolean status = parameterService.deleteTypeParameter(id);
		return ResponseEntity.ok(status);
	}
	
	@PutMapping (path = "/update/{id}")
	public ResponseEntity<TypeParameter> updateTypeParameter(@PathVariable ("id")Long id,@RequestBody TypeParameter parameter){
		TypeParameter type = parameterService.updateTypeParameter(id, parameter);
		return ResponseEntity.ok(type);
	}
}
