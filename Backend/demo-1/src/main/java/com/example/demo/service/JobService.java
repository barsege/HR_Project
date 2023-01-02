package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Departments;
import com.example.demo.entity.Job;

public interface JobService {
	List<Job> searchJobs(String query);
}
