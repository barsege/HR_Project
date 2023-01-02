package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.EmployeeInventoryInfo;
import com.example.demo.entity.EmployeeRoles;

public interface EmployeeRolesRepository extends JpaRepository<EmployeeRoles, Long>{

	@Query("Select p FROM EmployeeRoles p")
	List<EmployeeRoles> searchEmployeeRoles(String query);
}
