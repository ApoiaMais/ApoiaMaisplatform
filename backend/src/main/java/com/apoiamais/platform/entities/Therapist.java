package com.apoiamais.platform.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "therapist")
public class Therapist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String uriPhoto;
    
    @OneToMany(mappedBy = "therapist")
    private List<Telephone> telephones = new ArrayList<>();
    
    @OneToMany(mappedBy = "therapist")
    private List<Address> ListAddress = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(name = "therapist_specialty",
    joinColumns = @JoinColumn(name = "therapist_id"),
    inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialtys = new HashSet<>();
	
    public Therapist() {
		
	}

	public Therapist(Long id, String name, String cpf, String email, String uriPhoto) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Set<Specialty> getSpecialtys() {
		return specialtys;
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
		Therapist other = (Therapist) obj;
		return Objects.equals(id, other.id);
	}
    
	
    
    
    
   
    
    
    
}
