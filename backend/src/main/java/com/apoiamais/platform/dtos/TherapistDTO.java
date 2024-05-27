package com.apoiamais.platform.dtos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.apoiamais.platform.entities.Role;
import com.apoiamais.platform.entities.Therapist;

public class TherapistDTO extends UserDTO {
	
	private String license;
	
	public TherapistDTO() {
		
	}

	
	
	public TherapistDTO(Long id, String name, String email, String cpf, LocalDate birthDate, String uriPhoto, List<Role> roles, String license) {
		super(id, name, email, cpf, birthDate, uriPhoto, roles);
		this.license = license;
	}



	public TherapistDTO(Therapist entity) {
		super(entity.getId(), entity.getName(), entity.getEmail(), entity.getCpf(), entity.getBirthDate(), entity.getUriPhoto());
		this.license = entity.getLicense();
		for (GrantedAuthority role : entity.getAuthorities()) {
			this.getRoles().add(role.getAuthority());
		}
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}
	

}
