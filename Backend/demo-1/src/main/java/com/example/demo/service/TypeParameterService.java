package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Roles;
import com.example.demo.entity.TypeParameter;

public interface TypeParameterService {

	List<TypeParameter> searchTypeParameter (String query);
	
	Boolean deleteTypeParameter(Long id);
	
	TypeParameter updateTypeParameter(Long id, TypeParameter parameter);
	
	TypeParameter createTypeParameter(TypeParameter parameter);
}
