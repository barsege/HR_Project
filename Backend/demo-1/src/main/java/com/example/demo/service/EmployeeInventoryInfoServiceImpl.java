package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeInOutInfo;
import com.example.demo.entity.EmployeeInfo;
import com.example.demo.entity.EmployeeInventoryInfo;
import com.example.demo.entity.InventoryInfo;
import com.example.demo.repository.EmployeeInfoRepository;
import com.example.demo.repository.EmployeeInventoryInfoRepository;
import com.example.demo.repository.InventoryInfoRepository;

@Service
public class EmployeeInventoryInfoServiceImpl implements EmployeeInventoryInfoService{

	private InventoryInfoRepository invRepository;
	private EmployeeInfoRepository employeeInfoRepository;
	private EmployeeInventoryInfoRepository employeeInventoryInfoRepository;
	private List<EmployeeInventoryInfo> employeeInventoryInfos;
	
	
	

	public EmployeeInventoryInfoServiceImpl(InventoryInfoRepository invRepository,
			EmployeeInfoRepository employeeInfoRepository,
			EmployeeInventoryInfoRepository employeeInventoryInfoRepository) {
		super();
		this.invRepository = invRepository;
		this.employeeInfoRepository = employeeInfoRepository;
		this.employeeInventoryInfoRepository = employeeInventoryInfoRepository;
	}

	@PostConstruct
	private void publi() {
		// TODO Auto-generated method stub
		this.employeeInventoryInfos = new ArrayList<>();
	}
	
	@Override
	public List<EmployeeInventoryInfo> searchEmployeeInventoryInfo(String query) {
		List<EmployeeInventoryInfo> eIInfo = employeeInventoryInfoRepository.searchEmployeeInventoryInfo(query);
		
		return eIInfo;
	}

	@Override
	public Boolean deleteEmployeeInventoryInfo(Long id) {
		Optional<EmployeeInventoryInfo> eInfo = employeeInventoryInfoRepository.findById(id);
		if(eInfo.isPresent()) {
			employeeInventoryInfoRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public EmployeeInventoryInfo updateEmployeeInventoryInfo(Long id, EmployeeInventoryInfo employeeInventoryInfo) {
		Optional<EmployeeInventoryInfo> eInfo = employeeInventoryInfoRepository.findById(id);
		if(eInfo.isPresent()) {
			eInfo.get().setDeliveringEmployeeId(employeeInventoryInfo.getDeliveringEmployeeId());
			eInfo.get().setEmployeeInventoryid(employeeInventoryInfo.getEmployeeInventoryid());
			eInfo.get().setEmployeeRecieveDate(employeeInventoryInfo.getEmployeeRecieveDate());
			eInfo.get().setRecievingEmployeeId(employeeInventoryInfo.getRecievingEmployeeId());
			eInfo.get().setReturnedDateOfInventory(employeeInventoryInfo.getReturnedDateOfInventory());
			return employeeInventoryInfoRepository.save(eInfo.get());
		}
		return null;
	}

	@Override
	public EmployeeInventoryInfo createEmployeeInventoryInfo(EmployeeInventoryInfo employeeInventoryInfo) {
		return employeeInventoryInfoRepository.save(employeeInventoryInfo);
	}
	
	@Override
	public List<InventoryInfo> findByIdEmployeeInventoryInfo(Long id) {
		List<InventoryInfo> eInfo = employeeInventoryInfoRepository.findByIdEmployeeInventoryInfo(id);
		if(eInfo!= null) {
			return eInfo;
		}
		return null;
	}

	@Override
	public EmployeeInventoryInfo assignInventory(Long recievingEmployeeId,Long inventoryId) {
		Optional<EmployeeInfo> emp = employeeInfoRepository.findById(recievingEmployeeId);
		Optional<InventoryInfo> inv = invRepository.findById(inventoryId);
		
		
		EmployeeInventoryInfo eInvInfo = new EmployeeInventoryInfo();
		if(emp.isPresent() && inv.isPresent() && inv.get().getStatusId()!= 1L) {
			eInvInfo.setRecievingEmployeeId(recievingEmployeeId);
			eInvInfo.setEmployeeInventoryid(inventoryId);
			eInvInfo.setDeliveringEmployeeId(emp.get().getDeptId());
			eInvInfo.setEmployeeRecieveDate(emp.get().getDateOfBirth());
			eInvInfo.setReturnedDateOfInventory(emp.get().getDateOfBirth());
			eInvInfo.setEmployeeInfo(emp.get());
			eInvInfo.setInvInfo(inv.get());
			eInvInfo.getInvInfo().setStatusId(1L);
			return employeeInventoryInfoRepository.save(eInvInfo);
			
		}
		
		return null;
	}

	@Override
	public List<InventoryInfo> getUnassignedInventory(String query) {
		List<InventoryInfo> eIInfo = employeeInventoryInfoRepository.getUnassignedInventory(query);
		
		return eIInfo;
	}

	

	

}
