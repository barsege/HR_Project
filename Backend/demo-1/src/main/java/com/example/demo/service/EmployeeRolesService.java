package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EmployeeInventoryInfo;
import com.example.demo.entity.EmployeeRoles;

public interface EmployeeRolesService {

	List<EmployeeRoles> searchEmployeeRoles(String query);
	
	Boolean deleteEmployeeRoles(Long id);

	EmployeeRoles updateEmployeeRoles(Long id, EmployeeRoles employeeRoles);

	EmployeeRoles createEmployeeRoles(EmployeeRoles employeeRoles);
}
