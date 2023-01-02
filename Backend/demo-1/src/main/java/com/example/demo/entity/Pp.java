package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.print.DocFlavor.BYTE_ARRAY;

@Entity
@Table(name = "Pp")
public class Pp {
	
	@Id
	@Column(name = "Pp", nullable = true)
	private BYTE_ARRAY Pp;
	
	@Column(name = "id", nullable = false)
	private Long id;
	
	@OneToOne
	private EmployeeInfo e_info;

	
	
	public Pp(BYTE_ARRAY pp, Long id, EmployeeInfo e_info) {
		super();
		Pp = pp;
		this.id = id;
		this.e_info = e_info;
	}

	public BYTE_ARRAY getPp() {
		return Pp;
	}

	public void setPp(BYTE_ARRAY pp) {
		Pp = pp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmployeeInfo getE_info() {
		return e_info;
	}

	public void setE_info(EmployeeInfo e_info) {
		this.e_info = e_info;
	}
	
	
}
