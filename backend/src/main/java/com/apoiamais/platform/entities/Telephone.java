package com.apoiamais.platform.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "telephone")
public class Telephone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ddd;
	private String number;
	@ManyToOne
	@JoinColumn(name = "therapist_id")
	private Therapist therapist;
	
	@ManyToOne
	@JoinColumn(name = "Patient_id")
	private Patient patient;
	
	public Telephone() {
	
	}
	
	public Telephone(Long id, String ddd, String number) {
		
		this.id = id;
		this.ddd = ddd;
		this.number = number;
	}
	
	

	public Telephone(Long id, String ddd, String number, Therapist therapist, Patient patient) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.number = number;
		this.therapist = therapist;
		this.patient = patient;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Therapist getTherapist() {
		return therapist;
	}

	public void setTherapist(Therapist therapist) {
		this.therapist = therapist;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
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
		Telephone other = (Telephone) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
