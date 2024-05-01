package com.apoiamais.platform.entities;

import jakarta.persistence.Column;

public class Therapist extends User {
	
	@Column(nullable = false, unique = true)
	private String cpf;
	private String uriPhoto;
	@Column(nullable = false, unique = true)
	private String license;
	
	public Therapist() {
		super();
	}
	
	
	
	public Therapist(Long id, String name, String email, String password, String cpf, String uriPhoto, String license) {
		super(id, name, email, password);
		this.cpf = cpf;
		this.uriPhoto = uriPhoto;
		this.license = license;
	}



	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUriPhoto() {
		return uriPhoto;
	}

	public void setUriPhoto(String uriPhoto) {
		this.uriPhoto = uriPhoto;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}
	
	
	
	
    
}
