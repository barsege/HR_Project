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
@Table(name = "Roles")
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id", nullable = false)
	private Long roleId;
	
	@Column(name = "role_name", nullable = false, length = 30)
	private String roleName;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	/*
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "eRoles")
	private EmployeeRoles eRoles;
	*/
	
	
	
	
	
	
}
