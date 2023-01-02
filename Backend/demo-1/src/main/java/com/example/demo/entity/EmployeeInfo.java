package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "EmployeeInfo")
public class EmployeeInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private Long employeeId;

	@Column(name = "employee_name",  length = 50)
	private String employeeName;

	@Column(name = "employee_surname",  length = 50)
	private String employeeSurname;

	@Column(name = "gender", length = 10)
	private String gender;

	//@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "date_of_birth", length = 15)
	private Date dateOfBirth;

	@Column(name = "married_or_not", length = 3)
	private String marriedOrNot;

	@Column(name = "tckn")
	private Long TCKN;

	@Column(name = "grad_status_id")
	private Long gradStatusId;

	//@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "grad_date", length = 15)
	private Date gradDate;

	@Column(name = "dept_id")
	private Long deptId;

	@Column(name = "job_id")
	private Long jobId;

	@Column(name = "working_or_not", length = 3)
	private String workingOrNot;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeSurname() {
		return employeeSurname;
	}

	public void setEmployeeSurname(String employeeSurname) {
		this.employeeSurname = employeeSurname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMarriedOrNot() {
		return marriedOrNot;
	}

	public void setMarriedOrNot(String marriedOrNot) {
		this.marriedOrNot = marriedOrNot;
	}

	public Long getTCKN() {
		return TCKN;
	}

	public void setTCKN(Long tCKN) {
		TCKN = tCKN;
	}

	public Long getGradstatusId() {
		return gradStatusId;
	}

	public void setGradstatusId(Long gradstatusId) {
		this.gradStatusId = gradstatusId;
	}

	public Date getGradDate() {
		return gradDate;
	}

	public void setGradDate(Date gradDate) {
		this.gradDate = gradDate;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getWorkingOrNot() {
		return workingOrNot;
	}

	public void setWorkingOrNot(String workingOrNot) {
		this.workingOrNot = workingOrNot;
	}

	

}
