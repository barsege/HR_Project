package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.InventoryInfo;
import com.example.demo.entity.Roles;

public interface RolesService {

	List<Roles> searchRoles (String query);
	
	Boolean deleteRoles(Long id);
	
	Roles updateRoles(Long id, Roles roles);
	
	Roles createRoles(Roles roles);
}
