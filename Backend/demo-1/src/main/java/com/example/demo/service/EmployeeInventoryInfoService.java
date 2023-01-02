package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EmployeeInfo;
import com.example.demo.entity.EmployeeInventoryInfo;
import com.example.demo.entity.InventoryInfo;

public interface EmployeeInventoryInfoService {

	List<EmployeeInventoryInfo> searchEmployeeInventoryInfo(String query);
	
	Boolean deleteEmployeeInventoryInfo(Long id);

	EmployeeInventoryInfo updateEmployeeInventoryInfo(Long id, EmployeeInventoryInfo employeeInventoryInfo);

	EmployeeInventoryInfo createEmployeeInventoryInfo(EmployeeInventoryInfo employeeInventoryInfo);
	
	//EmployeeInventoryInfo getEmpById(Long id);
	
	List<InventoryInfo> findByIdEmployeeInventoryInfo (Long id);
	
	EmployeeInventoryInfo assignInventory(Long recievingEmployeeId,Long inventoryId);
	
	List<InventoryInfo> getUnassignedInventory(String query);
}
