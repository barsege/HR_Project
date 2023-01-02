package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.InventoryInfo;
import com.example.demo.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long>{

	@Query("SELECT p FROM Roles p")
	List<Roles> searchRoles(String query);
}
