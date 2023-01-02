package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_roles")
public class EmployeeRoles {
	//silme, ekleme, listeleme,find by
	@Id
	@Column(name = "emp_id")
	private Long empId;
	
	@Column(name = "role_id")
	private Long roleId;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public EmployeeRoles(Long empId, Long roleId) {
		super();
		this.empId = empId;
		this.roleId = roleId;
	}

	 public EmployeeRoles() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
