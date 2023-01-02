package com.example.demo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_Inventory_Info")
public class EmployeeInventoryInfo {
	@Id
	@Column(name = "employee_inventoryid")
	private Long employeeInventoryid;
	
	@Column(name = "employee_recieve_date",length = 15)
	private Date employeeRecieveDate;
	
	@Column(name = "delivering_employee_id")
	private Long deliveringEmployeeId;
	
	@Column(name = "returned_dateOf_inventory",length = 15)
	private Date returnedDateOfInventory;
	
	@Column(name = "recieving_employee_id")
	private Long recievingEmployeeId;

	@JoinColumn(name = "invInfo")
	@OneToOne(targetEntity = InventoryInfo.class)
	private InventoryInfo invInfo;

	@JoinColumn(name = "employeeInfo",referencedColumnName = "employee_id")
	@OneToOne(targetEntity = EmployeeInfo.class)
	private EmployeeInfo employeeInfo;
	
	
	
	
	public InventoryInfo getInvInfo() {
		return invInfo;
	}

	public void setInvInfo(InventoryInfo invInfo) {
		this.invInfo = invInfo;
	}

	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	public Long getEmployeeInventoryid() {
		return employeeInventoryid;
	}

	public void setEmployeeInventoryid(Long employeeInventoryid) {
		this.employeeInventoryid = employeeInventoryid;
	}

	public Date getEmployeeRecieveDate() {
		return employeeRecieveDate;
	}

	public void setEmployeeRecieveDate(Date employeeRecieveDate) {
		this.employeeRecieveDate = employeeRecieveDate;
	}

	public Long getDeliveringEmployeeId() {
		return deliveringEmployeeId;
	}

	public void setDeliveringEmployeeId(Long deliveringEmployeeId) {
		this.deliveringEmployeeId = deliveringEmployeeId;
	}

	public Date getReturnedDateOfInventory() {
		return returnedDateOfInventory;
	}

	public void setReturnedDateOfInventory(Date returnedDateOfInventory) {
		this.returnedDateOfInventory = returnedDateOfInventory;
	}

	public Long getRecievingEmployeeId() {
		return recievingEmployeeId;
	}

	public void setRecievingEmployeeId(Long recievingEmployeeId) {
		this.recievingEmployeeId = recievingEmployeeId;
	}


	
}
