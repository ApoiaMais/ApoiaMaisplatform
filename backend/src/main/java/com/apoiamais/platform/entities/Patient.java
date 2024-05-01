package com.apoiamais.platform.entities;

import java.util.Date;

import jakarta.persistence.Column;

public class Patient extends User {

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Date birthDate;
	@Column(nullable = false, unique = true)
	private String cpf;
	@Column(nullable = false, unique = true)
	private String rg;
	@Column(nullable = false, unique = true)
	private String nis;
	
	public Patient() {
		

	}

	public Patient(Long id, String name, String email, String password, Date birthDate, String cpf, String rg,
			String nis) {
		super(id, name, email, password);
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.rg = rg;
		this.nis = nis;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNis() {
		return nis;
	}

	public void setNis(String nis) {
		this.nis = nis;
	}
	
	
	
	
	
	
}
