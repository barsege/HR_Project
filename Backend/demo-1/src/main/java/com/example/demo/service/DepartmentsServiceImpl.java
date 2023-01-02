package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Departments;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentsServiceImpl implements DepartmentsService{

	DepartmentRepository departmentRepository;
	List<Departments> departments;
	
	@PostConstruct
	private void publi() {
		this.departments = new ArrayList<>();
	}
	
	public DepartmentsServiceImpl(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}



	@Override
	public List<Departments> searchDepts(String query) {
		List<Departments> departments = departmentRepository.searchDepts(query);
		return departments;
	}

	@Override
	public Departments createDepartments(Departments departments) {
		
		return departmentRepository.save(departments);
	}

	@Override
	public Boolean deleteDepartments(Long deptId) {
		Optional<Departments> deps = departmentRepository.findById(deptId);
		if(deps.isPresent()) {
			departmentRepository.deleteById(deptId);
			return true;
		}
		
		return false;
	}

	@Override
	public Departments updateDepartments(Long deptId, Departments departments) {
		Optional<Departments> deps = departmentRepository.findById(deptId);
		if(deps.isPresent()) {
			deps.get().setDeptId(deptId);
			deps.get().setDeptName(departments.getDeptName()); 
			return departmentRepository.save(deps.get());
		}
		return null;
	}
	
}
