package com.apoiamais.platform.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name = "tb_patient")
public class Patient extends User {

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private LocalDate birthDate;
	@Column(nullable = false, unique = true)
	private String cpf;
	@Column(nullable = false, unique = true)
	private String rg;
	@Column(nullable = false, unique = true)
	private String nis;
	
	public Patient() {
		

	}

	public Patient(Long id, String name, String email, String password, LocalDate birthDate, String cpf, String rg,
			String nis) {
		super(id, name, email, password);
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.rg = rg;
		this.nis = nis;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
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
