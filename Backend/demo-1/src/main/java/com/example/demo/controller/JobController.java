package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Departments;
import com.example.demo.entity.Job;
import com.example.demo.service.JobService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/jobs")
public class JobController {

	JobService jobService;
	
	@GetMapping("/search")
	public ResponseEntity<List<Job>> searchJobs (@RequestParam ("query") String query){
		return ResponseEntity.ok(jobService.searchJobs(query));
		
		
	}

	public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
}
