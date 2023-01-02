package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Inventory_info")
public class InventoryInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inventory_id", nullable = false)
	private Long inventoryId;
	
	@Column(name = "brand", length = 15)
	private String brand;
	
	@Column(name = "model", length = 15)
	private String model;
	
	@Column(name = "inventory_in_date",length = 15)
	private Date inventoryInDate;
	
	@Column(name = "serial_no")
	private Long serialNo;
	
	@Column(name = "status_id")
	private Long statusId;
	
	@Column(name = "inventory_type")
	private Long inventoryType;

	
	
	public InventoryInfo(Long inventoryId, String brand, String model, Date inventoryInDate, Long serialNo,
			Long statusId, Long inventoryType) {
		super();
		this.inventoryId = inventoryId;
		this.brand = brand;
		this.model = model;
		this.inventoryInDate = inventoryInDate;
		this.serialNo = serialNo;
		this.statusId = statusId;
		this.inventoryType = inventoryType;
	}

	
	
	
	public InventoryInfo() {
		super();
	}




	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getInventoryInDate() {
		return inventoryInDate;
	}

	public void setInventoryInDate(Date inventoryInDate) {
		this.inventoryInDate = inventoryInDate;
	}

	public Long getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(Long serialNo) {
		this.serialNo = serialNo;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Long getInventoryType() {
		return inventoryType;
	}

	public void setInventoryType(Long inventoryType) {
		this.inventoryType = inventoryType;
	}

	
	
	
	
	
}
