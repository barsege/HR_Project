package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Departments;
import com.example.demo.entity.Job;
import com.example.demo.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService {

	private JobRepository jobRepository;
	private List<Job> jobs;
	
	@PostConstruct
	private void publi() {
		this.jobs = new ArrayList<>();
	}
	
	
	public JobServiceImpl(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}

	

	@Override
	public List<Job> searchJobs(String query) {
		List<Job> jobs = jobRepository.searchJobs(query);
		return jobs;
	}

}
