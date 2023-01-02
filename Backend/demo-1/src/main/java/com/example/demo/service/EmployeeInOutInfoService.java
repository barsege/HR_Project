package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EmployeeInOutInfo;

public interface EmployeeInOutInfoService {

	List<EmployeeInOutInfo> searchEmployeeInOutInfo(String query);
		
	Boolean deleteEmployeeInOutInfo(Long id);

	EmployeeInOutInfo updateEmployeeInOutInfo(Long id, EmployeeInOutInfo employeeInOutInfo);

	EmployeeInOutInfo createEmployeeInOutInfo(EmployeeInOutInfo employeeInOutInfo);
	
}
