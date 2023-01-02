package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeInOutInfo;
import com.example.demo.entity.EmployeeInfo;
import com.example.demo.repository.EmployeeInOutInfoRepository;

@Service
public class EmployeeInOutInfoServiceImpl implements EmployeeInOutInfoService{
	private EmployeeInOutInfoRepository employeeInOutInfoRepository;	
	private List<EmployeeInOutInfo> employeeInOutInfos;
	
	
	
	public EmployeeInOutInfoServiceImpl(EmployeeInOutInfoRepository employeeInOutInfoRepository) {
		super();
		this.employeeInOutInfoRepository = employeeInOutInfoRepository;
	}

	@PostConstruct
	private void publi() {
		// TODO Auto-generated method stub
		this.employeeInOutInfos = new ArrayList<>();
	}
	
	@Override
	public List<EmployeeInOutInfo> searchEmployeeInOutInfo(String query) {
		List<EmployeeInOutInfo> eInfo = employeeInOutInfoRepository.searchEmpInOut(query);
		
		return eInfo;
	}


	@Override
	public Boolean deleteEmployeeInOutInfo(Long id) {
		Optional<EmployeeInOutInfo> eInfo = employeeInOutInfoRepository.findById(id);
		if(eInfo.isPresent()) {
			employeeInOutInfoRepository.deleteById(id);
			return true;
		}
		return false;
	}


	@Override
	public EmployeeInOutInfo updateEmployeeInOutInfo(Long id, EmployeeInOutInfo employeeInOutInfo) {
		Optional<EmployeeInOutInfo> eInfo = employeeInOutInfoRepository.findById(id);
		if(eInfo.isPresent()) {
			eInfo.get().setEmployeeInDate(employeeInOutInfo.getEmployeeInDate());
			eInfo.get().setEmployeeInPositionId(employeeInOutInfo.getEmployeeInPositionId());
			eInfo.get().setEmployeeInTitle(employeeInOutInfo.getEmployeeInTitle());
			eInfo.get().setEmployeeOutDate(employeeInOutInfo.getEmployeeOutDate());
			eInfo.get().setReasonForOut(employeeInOutInfo.getReasonForOut());
			return employeeInOutInfoRepository.save(eInfo.get());
		}
		return null;
	}


	@Override
	public EmployeeInOutInfo createEmployeeInOutInfo(EmployeeInOutInfo employeeInOutInfo) {
		return employeeInOutInfoRepository.save(employeeInOutInfo);
	}
	
	
}	
