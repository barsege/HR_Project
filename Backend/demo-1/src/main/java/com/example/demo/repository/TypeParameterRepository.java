package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Roles;
import com.example.demo.entity.TypeParameter;

public interface TypeParameterRepository extends JpaRepository<TypeParameter, Long>{

	@Query("SELECT p FROM TypeParameter p")
	List<TypeParameter> searchTypeParameter(String query);
}
