package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Departments")
public class Departments {
	
	@Id
	@Column(name = "dept_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long deptId;

	@Column(name = "dept_name",nullable = false, length = 50)
	private String deptName;

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
}
