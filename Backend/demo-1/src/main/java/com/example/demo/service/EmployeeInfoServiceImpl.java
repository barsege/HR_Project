package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeInfo;
import com.example.demo.repository.EmployeeInfoRepository;

@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService{

	private EmployeeInfoRepository employeeInfoRepository;
	private List<EmployeeInfo> employees;
	
	@PostConstruct
	private void publi() {
		// TODO Auto-generated method stub
		this.employees = new ArrayList<>();
	}
	
	
	
	
	public EmployeeInfoServiceImpl(EmployeeInfoRepository employeeInfoRepository) {
		super();
		this.employeeInfoRepository = employeeInfoRepository;
	}

	@Override
	public List<EmployeeInfo> searchEmployeeInfo(String query) {
		List<EmployeeInfo> eInfo = employeeInfoRepository.search_emp(query);
		
		return eInfo;
	}

	@Override
	public EmployeeInfo createEmployeeInfo(EmployeeInfo employeeInfo) {
		// TODO Auto-generated method stub
		return employeeInfoRepository.save(employeeInfo);
	}
	
	@Override
	public Boolean deleteEmployeeInfo (Long employeeId) {
		Optional<EmployeeInfo> eInfo = employeeInfoRepository.findById(employeeId);
		if(eInfo.isPresent()) {
			employeeInfoRepository.deleteById(employeeId);
			return true;
		}
		return false;
		
	}
	
	@Override
	public EmployeeInfo updateEmployeeInfo (Long employeeId, EmployeeInfo employeeInfo) {
	
		Optional<EmployeeInfo> eInfo = employeeInfoRepository.findById(employeeId);
		if(eInfo.isPresent()) {
			eInfo.get().setDateOfBirth(employeeInfo.getDateOfBirth());
			eInfo.get().setDeptId(employeeInfo.getDeptId());
			eInfo.get().setEmployeeName(employeeInfo.getEmployeeName());
			eInfo.get().setEmployeeSurname(employeeInfo.getEmployeeSurname());
			eInfo.get().setGender(employeeInfo.getGender());
			eInfo.get().setGradDate(employeeInfo.getGradDate());
			eInfo.get().setGradstatusId(employeeInfo.getGradstatusId());
			eInfo.get().setJobId(employeeInfo.getJobId());
			eInfo.get().setMarriedOrNot(employeeInfo.getMarriedOrNot());
			eInfo.get().setTCKN(employeeInfo.getTCKN());
			eInfo.get().setWorkingOrNot(employeeInfo.getWorkingOrNot());
			
			return employeeInfoRepository.save(eInfo.get());
		}
		return null;
		
	}




	@Override
	public EmployeeInfo getEmpById(Long id) {
		Optional<EmployeeInfo> eInfo = employeeInfoRepository.findById(id);
		if(eInfo.isPresent()) {
			return eInfo.get();
		}
		return null;
	}

}
