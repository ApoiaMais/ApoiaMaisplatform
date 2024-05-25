package com.apoiamais.platform.dtos;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.apoiamais.platform.entities.Role;
import com.apoiamais.platform.entities.User;

public class UserDTO {
	
	private Long id;
	private String name;
	private String email;
	private String cpf;
	private LocalDate birthDate;
	private String uriPhoto;
	private List<String> roles =  new ArrayList<>();
	
	public UserDTO() {
		
	}
	
	

	public UserDTO(Long id, String name, String email, String cpf, LocalDate birthDate, String uriPhoto, List<Role> roles) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.uriPhoto = uriPhoto;
		for (GrantedAuthority role : roles) {
			this.roles.add(role.getAuthority());
		}
	}
	
	public UserDTO(Long id, String name, String email, String cpf, LocalDate birthDate, String uriPhoto) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.uriPhoto = uriPhoto;
	}



	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		cpf = entity.getCpf();
		uriPhoto = entity.getUriPhoto();
		birthDate = entity.getBirthDate();
		for (GrantedAuthority role : entity.getAuthorities()) {
			roles.add(role.getAuthority());
		}
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public LocalDate getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}



	public String getUriPhoto() {
		return uriPhoto;
	}



	public void setUriPhoto(String uriPhoto) {
		this.uriPhoto = uriPhoto;
	}



	public List<String> getRoles() {
		return roles;
	}
	
	
	
}