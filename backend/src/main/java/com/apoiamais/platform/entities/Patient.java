package com.apoiamais.platform.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Date birthDate;
	private String cpf;
	private String rg;
	private String nis;
	private String email;
	private String uriPhoto;
	
	@OneToMany(mappedBy = "patient")
	private List<Telephone> telephones = new ArrayList<>();
	
	@OneToMany(mappedBy = "patient")
    private List<Address> ListAddress = new ArrayList<>();

	@OneToMany(mappedBy = "patient")
	private List<Consultation> consultations = new ArrayList<>();
	
	

	public Patient() {
		
	}

	public Patient(Long id, String name, Date birthDate, String cpf, String rg, String nis, String email,
			String uriPhoto) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.rg = rg;
		this.nis = nis;
		this.email = email;
		this.uriPhoto = uriPhoto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUriPhoto() {
		return uriPhoto;
	}

	public void setUriPhoto(String uriPhoto) {
		this.uriPhoto = uriPhoto;
	}

	public List<Telephone> getTelephones() {
		return telephones;
	}

	public List<Address> getListAddress() {
		return ListAddress;
	}
	
	public List<Consultation> getConsultations() {
		return consultations;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	
	
	
	
}
