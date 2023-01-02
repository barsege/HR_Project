package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.EmployeeInOutInfo;
import com.example.demo.entity.EmployeeInventoryInfo;
import com.example.demo.entity.InventoryInfo;


public interface EmployeeInventoryInfoRepository extends JpaRepository<EmployeeInventoryInfo, Long>{

	@Query("Select p FROM EmployeeInventoryInfo p")
	List<EmployeeInventoryInfo> searchEmployeeInventoryInfo(String query);
	
	@Query("Select p.invInfo FROM EmployeeInventoryInfo p where p.recievingEmployeeId=:id")
	List<InventoryInfo> findByIdEmployeeInventoryInfo(Long id);
	
	@Query("Select p FROM InventoryInfo p where p.statusId = 0L")
	List<InventoryInfo> getUnassignedInventory(String query);
	
	//@Query("Select p.employeeInventoryid FROM EmployeeInventoryInfo p where p.")
}
