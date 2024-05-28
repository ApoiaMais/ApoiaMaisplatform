package com.apoiamais.platform.dtos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.apoiamais.platform.entities.Patient;
import com.apoiamais.platform.entities.Role;

public class PatientDTO extends UserDTO {
	
	private String nis;
	private String password;

	public PatientDTO() {
	}

	public PatientDTO(Long id, String name, String email, String cpf, LocalDate birthDate, String uriPhoto,
			String nis, String password) {
		super(id, name, email, cpf, birthDate, uriPhoto);
		this.nis = nis;
		this.password = password;
	}

	public PatientDTO(Long id, String name, String email, String cpf, LocalDate birthDate, String uriPhoto,
			List<Role> roles, String nis, String password) {
		super(id, name, email, cpf, birthDate, uriPhoto, roles);
		this.nis = nis;
		this.password = password;
	}
	
	public PatientDTO(Patient entity) {
		super(entity.getId(), entity.getName(), entity.getEmail(),
				entity.getCpf(), entity.getBirthDate(), entity.getUriPhoto());
		this.nis = entity.getNis();
		this.password = entity.getPassword(); // Ensure this is included
		for (GrantedAuthority role : entity.getAuthorities()) {
			this.getRoles().add(role.getAuthority());
		}
	}

	public String getNis() {
		return nis;
	}

	public void setNis(String nis) {
		this.nis = nis;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
