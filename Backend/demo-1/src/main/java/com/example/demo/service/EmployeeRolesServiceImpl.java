package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeRoles;
import com.example.demo.entity.InventoryInfo;
import com.example.demo.repository.EmployeeRolesRepository;

@Service
public class EmployeeRolesServiceImpl implements EmployeeRolesService {

	
	@Autowired
	private EmployeeRolesRepository employeeRolesRepository;
	
	
	private List<EmployeeRoles> employeeRoles;
	
	
	
	public EmployeeRolesServiceImpl(EmployeeRolesRepository employeeRolesRepository) {
		super();
		this.employeeRolesRepository = employeeRolesRepository;
	}


	@PostConstruct
	private void publi() {
		// TODO Auto-generated method stub
		this.employeeRoles = new ArrayList<>();
	}
	
	
	@Override
	public List<EmployeeRoles> searchEmployeeRoles(String query) {
		List<EmployeeRoles> eRoles = employeeRolesRepository.searchEmployeeRoles(query);
		return eRoles;
		
	}

	@Override
	public Boolean deleteEmployeeRoles(Long id) {
		Optional<EmployeeRoles> eRoles = employeeRolesRepository.findById(id);
		if(eRoles.isPresent()) {
			employeeRolesRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public EmployeeRoles updateEmployeeRoles(Long id, EmployeeRoles employeeRoles) {
		Optional <EmployeeRoles> eRole = employeeRolesRepository.findById(id);
		if(eRole.isPresent()) {
			eRole.get().setRoleId(employeeRoles.getRoleId());
			eRole.get().setEmpId(employeeRoles.getEmpId());
			return employeeRolesRepository.save(eRole.get());
		}
		return null;
	}

	@Override
	public EmployeeRoles createEmployeeRoles(EmployeeRoles employeeRoles) {
		return employeeRolesRepository.save(employeeRoles);
	}

}
