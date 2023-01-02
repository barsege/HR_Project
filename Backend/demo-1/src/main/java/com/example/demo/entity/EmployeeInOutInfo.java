package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeInOutInfo")
public class EmployeeInOutInfo {
	@Id
	@Column(name = "employee_id", nullable = false)
	private Long employeeId;
	
	@Column(name = "employee_in_date", nullable = false, length = 15)
	private Date employeeInDate ;
	
	
	public EmployeeInOutInfo() {
		super();
	}

	@Column(name = "employee_in_position_id")
	private Long employeeInPositionId;
	
	@Column(name = "employee_in_title", length = 50)
	private String employeeInTitle;
	
	@Column(name = "employee_out_date", length = 15)
	private Date employeeOutDate;
	
	@Column(name = "reason_for_out", length = 50)
	private String reasonForOut;

	@OneToOne
	@JoinColumn(name = "e_fk", referencedColumnName = "employee_id")
	private EmployeeInfo employeeInfo;


	
	
	public EmployeeInOutInfo(Long employeeId, Date employeeInDate, Long employeeInPositionId, String employeeInTitle,
			Date employeeOutDate, String reasonForOut, EmployeeInfo employeeInfo) {
		super();
		this.employeeId = employeeId;
		this.employeeInDate = employeeInDate;
		this.employeeInPositionId = employeeInPositionId;
		this.employeeInTitle = employeeInTitle;
		this.employeeOutDate = employeeOutDate;
		this.reasonForOut = reasonForOut;
		this.employeeInfo = employeeInfo;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Date getEmployeeInDate() {
		return employeeInDate;
	}

	public void setEmployeeInDate(Date employeeInDate) {
		this.employeeInDate = employeeInDate;
	}

	public Long getEmployeeInPositionId() {
		return employeeInPositionId;
	}

	public void setEmployeeInPositionId(Long employeeInPositionId) {
		this.employeeInPositionId = employeeInPositionId;
	}

	public String getEmployeeInTitle() {
		return employeeInTitle;
	}

	public void setEmployeeInTitle(String employeeInTitle) {
		this.employeeInTitle = employeeInTitle;
	}

	public Date getEmployeeOutDate() {
		return employeeOutDate;
	}

	public void setEmployeeOutDate(Date employeeOutDate) {
		this.employeeOutDate = employeeOutDate;
	}

	public String getReasonForOut() {
		return reasonForOut;
	}

	public void setReasonForOut(String reasonForOut) {
		this.reasonForOut = reasonForOut;
	}

	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	
}
