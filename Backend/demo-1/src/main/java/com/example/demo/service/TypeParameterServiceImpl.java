package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;


import com.example.demo.entity.TypeParameter;
import com.example.demo.repository.TypeParameterRepository;

@Service
public class TypeParameterServiceImpl implements TypeParameterService{

	private TypeParameterRepository parameterRepository;
	private List<TypeParameter> types;
	
	
	public TypeParameterServiceImpl(TypeParameterRepository parameterRepository) {
		super();
		this.parameterRepository = parameterRepository;
	}

	@PostConstruct
	private void publi() {
		// TODO Auto-generated method stub
		this.types = new ArrayList<>();
	}
	
	@Override
	public List<TypeParameter> searchTypeParameter(String query) {
		List<TypeParameter> types = parameterRepository.searchTypeParameter(query);
		return types;
	}

	@Override
	public Boolean deleteTypeParameter(Long id) {
		Optional<TypeParameter> type = parameterRepository.findById(id);
		if(type.isPresent()) {
			parameterRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public TypeParameter updateTypeParameter(Long id, TypeParameter parameter) {
		Optional<TypeParameter> type = parameterRepository.findById(id);
		if(type.isPresent()) {
			type.get().setId(parameter.getId());
			type.get().setMasterType(parameter.getMasterType());
			type.get().setTypeDesc(parameter.getTypeDesc());
			return parameterRepository.save(type.get());
		}
		return null;
	}

	@Override
	public TypeParameter createTypeParameter(TypeParameter parameter) {
		return parameterRepository.save(parameter);
	}

}
