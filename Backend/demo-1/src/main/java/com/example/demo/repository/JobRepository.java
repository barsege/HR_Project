package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.InventoryInfo;
import com.example.demo.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

	@Query("SELECT p FROM Job p")
	List<Job> searchJobs(String query);

}
