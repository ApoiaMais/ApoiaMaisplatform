package com.apoiamais.platform.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@SuppressWarnings("serial")
@Entity
@Table(name = "tb_patient")
public class Patient extends User {

	@Column(nullable = false, unique = true)
	private String nis;

	
	
	public Patient() {
		

	}

	public Patient(String nis) {
		super();
		this.nis = nis;
	}

	public String getNis() {
		return nis;
	}

	public void setNis(String nis) {
		this.nis = nis;
	}
	
}
