package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Departments;

public interface DepartmentsService {
	List<Departments> searchDepts(String query);
	
	Departments createDepartments(Departments departments);
	
	Boolean deleteDepartments(Long deptId);
	
	Departments updateDepartments (Long deptId, Departments departments);
}
