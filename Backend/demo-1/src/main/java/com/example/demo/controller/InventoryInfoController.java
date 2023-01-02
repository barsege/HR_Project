package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.InventoryInfo;
import com.example.demo.service.InventoryInfoService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/inventoryInfo")
public class InventoryInfoController {
	private InventoryInfoService infoService;

	public InventoryInfoController(InventoryInfoService infoService) {
		super();
		this.infoService = infoService;
	}
	
	@GetMapping(path = "/search")
	public ResponseEntity<List<InventoryInfo>> searchInventoryInfo(@RequestParam ("query")String query){
		return ResponseEntity.ok(infoService.searchInventoryInfo(query));
	}
	
	@GetMapping(path = "/searchById/{invId}")
	public ResponseEntity<InventoryInfo> getInvById(@PathVariable ("invId")Long id){
		InventoryInfo info = infoService.getInvById(id);
		
		return ResponseEntity.ok(info);
	}
	
	@PostMapping(path = "/addInventory")
	public InventoryInfo createInventoryInfo(@RequestBody InventoryInfo info) {
		return infoService.createInventoryInfo(info);
	}
	
	@DeleteMapping(path = "/delete/{invId}")
	public ResponseEntity<Boolean> deleteInventoryInfo(@PathVariable ("invId") Long id){
		Boolean status = infoService.deleteInventoryInfo(id);
		return ResponseEntity.ok(status);
	}
	
	@PutMapping(path = "/update/{invId}")
	public ResponseEntity<InventoryInfo> updateInventoryInfo(@PathVariable ("invId") Long id, @RequestBody InventoryInfo info){
		InventoryInfo iInfo = infoService.updateInventoryInfo(id, info);
		return ResponseEntity.ok(iInfo);
	}
}
