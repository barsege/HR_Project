package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GraduationStatus")
public class Graduation {

	@Id
	@Column(name = "graduation_id")
	private Long graduationId;

	@Column(name = "graduation_name",  length = 20)
	private String graduationName;

	public Long getGraduationId() {
		return graduationId;
	}

	public void setGraduationId(Long graduationId) {
		this.graduationId = graduationId;
	}

	public String getGraduationName() {
		return graduationName;
	}

	public void setGraduationName(String graduationName) {
		this.graduationName = graduationName;
	}

	public Graduation(Long graduationId, String graduationName) {
		super();
		this.graduationId = graduationId;
		this.graduationName = graduationName;
	}

	public Graduation() {
		super();
	}
	
	
	
}
