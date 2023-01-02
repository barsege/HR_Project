package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeInOutInfo;
import com.example.demo.entity.InventoryInfo;
import com.example.demo.repository.InventoryInfoRepository;

@Service
public class InventoryInfoServiceImpl implements InventoryInfoService{

	private InventoryInfoRepository infoRepository;
	private List<InventoryInfo> infos;
	
	public InventoryInfoServiceImpl(InventoryInfoRepository infoRepository) {
		super();
		this.infoRepository = infoRepository;
	}
	
	@PostConstruct
	private void publi() {
		// TODO Auto-generated method stub
		this.infos = new ArrayList<>();
	}

	@Override
	public List<InventoryInfo> searchInventoryInfo(String query) {
		List<InventoryInfo> invInfo = infoRepository.search_Inventory(query);
		return invInfo;
	}

	@Override
	public Boolean deleteInventoryInfo(Long id) {
		Optional<InventoryInfo> iInfo = infoRepository.findById(id);
		if(iInfo.isPresent()) {
			infoRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public InventoryInfo updateInventoryInfo(Long id, InventoryInfo info) {
		Optional<InventoryInfo> iInfo = infoRepository.findById(id);
		if(iInfo.isPresent()) {
			iInfo.get().setInventoryId(info.getInventoryId());
			iInfo.get().setInventoryInDate(info.getInventoryInDate());
			iInfo.get().setInventoryType(info.getInventoryType());
			iInfo.get().setModel(info.getModel());
			iInfo.get().setSerialNo(info.getSerialNo());
			iInfo.get().setStatusId(info.getStatusId());
			iInfo.get().setBrand(info.getBrand());
			
			return infoRepository.save(iInfo.get());
		}
		return null;
	}

	@Override
	public InventoryInfo createInventoryInfo(InventoryInfo info) {
		return infoRepository.save(info);
	}

	@Override
	public InventoryInfo getInvById(Long id) {
		Optional <InventoryInfo> info = infoRepository.findById(id);
		if(info.isPresent()) {
			return info.get();
		}
		return null;
		
	}
	
	
}
