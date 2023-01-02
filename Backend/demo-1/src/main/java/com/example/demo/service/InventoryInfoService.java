package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.InventoryInfo;
public interface InventoryInfoService {

	List<InventoryInfo> searchInventoryInfo (String query);
	
	Boolean deleteInventoryInfo(Long id);
	
	InventoryInfo updateInventoryInfo(Long id, InventoryInfo info);
	
	InventoryInfo createInventoryInfo(InventoryInfo info);
	
	InventoryInfo getInvById (Long id);
}
