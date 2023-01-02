package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.EmployeeInfo;
import com.example.demo.entity.InventoryInfo;

public interface InventoryInfoRepository extends JpaRepository<InventoryInfo, Long>{

	@Query("SELECT p FROM InventoryInfo p")
	List<InventoryInfo> search_Inventory(String query);
}
