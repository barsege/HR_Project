package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.EmployeeInfo;

public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo, Long>{
	
	@Query("SELECT p FROM EmployeeInfo p")
	List<EmployeeInfo> search_emp(String query);
}
