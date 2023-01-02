package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "type_parameter")
public class TypeParameter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "master_type", nullable = false, length = 50)
	private String masterType;
	
	@Column(name = "type_desc", nullable = false, length = 50)
	private String typeDesc;
	/*
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "job_id_fk")
	private EmployeeInfo e_info;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "inventory_type_fk")
	private InventoryInfo i_info;
	*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMasterType() {
		return masterType;
	}

	public void setMasterType(String masterType) {
		this.masterType = masterType;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	
	
	
}
