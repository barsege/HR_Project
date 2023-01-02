package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Graduation;
import com.example.demo.entity.Job;

public interface GraduationRepository extends JpaRepository<Graduation, Long> {
	
	@Query("SELECT p FROM Graduation p")
	List<Graduation> searchGrad(String query);
}
