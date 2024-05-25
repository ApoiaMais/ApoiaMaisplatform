package com.apoiamais.platform.dtos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.apoiamais.platform.entities.Patient;
import com.apoiamais.platform.entities.Role;

public class PatientDTO extends UserDTO {
	
	private String nis;

	public PatientDTO() {
	}

	public PatientDTO(Long id, String name, String email, String cpf, LocalDate birthDate, String uriPhoto,
			String nis) {
		super(id, name, email, cpf, birthDate, uriPhoto);
		this.nis = nis;
	}

	public PatientDTO(Long id, String name, String email, String cpf, LocalDate birthDate, String uriPhoto,
			List<Role> roles, String nis) {
		super(id, name, email, cpf, birthDate, uriPhoto, roles);
		this.nis = nis;
	}
	
	public PatientDTO(Patient entity) {
		super(entity.getId(), entity.getName(), entity.getEmail(),
				entity.getCpf(), entity.getBirthDate(), entity.getUriPhoto());
		this.nis = entity.getNis();
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
	
	
}
