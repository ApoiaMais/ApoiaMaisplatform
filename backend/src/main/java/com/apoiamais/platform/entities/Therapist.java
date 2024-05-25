package com.apoiamais.platform.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@SuppressWarnings("serial")
@Entity
@Table(name = "tb_therapist")
public class Therapist extends User {
	
	
	@Column(nullable = false, unique = true)
	private String license;
	
	public Therapist() {
	}
	
	
	public Therapist(String license) {
		this.license = license;
	}



	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}
	
    
}
