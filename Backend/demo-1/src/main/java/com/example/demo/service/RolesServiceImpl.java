package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.demo.entity.InventoryInfo;
import com.example.demo.entity.Roles;
import com.example.demo.repository.RolesRepository;

@Service
public class RolesServiceImpl implements RolesService{

	private RolesRepository rolesRepository;
	private List<Roles> roles;
	

	public RolesServiceImpl(RolesRepository rolesRepository) {
		super();
		this.rolesRepository = rolesRepository;
	}

	@PostConstruct
	private void publi() {
		// TODO Auto-generated method stub
		this.roles = new ArrayList<>();
	}
	
	@Override
	public List<Roles> searchRoles(String query) {
		List<Roles> roles = rolesRepository.searchRoles(query);
		return roles;
	}

	@Override
	public Boolean deleteRoles(Long id) {
		Optional<Roles> rInfo = rolesRepository.findById(id);
		if(rInfo.isPresent()) {
			rolesRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Roles updateRoles(Long id, Roles roles) {
		Optional<Roles> RInfo = rolesRepository.findById(id);
		if(RInfo.isPresent()) {
			RInfo.get().setRoleId(roles.getRoleId());
			RInfo.get().setRoleName(roles.getRoleName());
			return rolesRepository.save(RInfo.get());
		}
		return null;
	}

	@Override
	public Roles createRoles(Roles roles) {
		return rolesRepository.save(roles);
	}

}
