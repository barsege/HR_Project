package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Departments;

public interface DepartmentRepository extends JpaRepository<Departments,Long> {

	@Query("SELECT p FROM Departments p")
	List<Departments> searchDepts(String query);

}
