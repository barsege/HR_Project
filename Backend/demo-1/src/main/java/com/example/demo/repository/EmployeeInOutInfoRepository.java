package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.EmployeeInOutInfo;

public interface EmployeeInOutInfoRepository extends JpaRepository<EmployeeInOutInfo, Long> {

	@Query("Select p FROM EmployeeInOutInfo p")
	List<EmployeeInOutInfo> searchEmpInOut(String query);
}
