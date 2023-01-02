package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Graduation;
import com.example.demo.entity.Job;
import com.example.demo.service.GraduationService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/graduation")
public class GraduationController {
	@Autowired
	private GraduationService graduationService;

	public GraduationController(GraduationService graduationService) {
		super();
		this.graduationService = graduationService;
	}

	public GraduationController() {
		super();
	}

	@GetMapping("/search")
	public ResponseEntity<List<Graduation>> searchGrad (@RequestParam ("query") String query){
		return ResponseEntity.ok(graduationService.searchGrad(query));
		
	}
	
	
}
