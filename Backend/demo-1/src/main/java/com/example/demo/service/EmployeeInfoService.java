package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EmployeeInfo;

public interface EmployeeInfoService {

	List<EmployeeInfo> searchEmployeeInfo(String query);
	
	EmployeeInfo createEmployeeInfo(EmployeeInfo employeeInfo);

	Boolean deleteEmployeeInfo(Long employeeInfo);

	EmployeeInfo updateEmployeeInfo(Long employeeId, EmployeeInfo employeeInfo);
	
	EmployeeInfo getEmpById(Long id);
	
}
