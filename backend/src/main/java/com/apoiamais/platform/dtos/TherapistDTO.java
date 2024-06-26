package com.apoiamais.platform.dtos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.apoiamais.platform.entities.Role;
import com.apoiamais.platform.entities.Therapist;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TherapistDTO extends UserDTO {
	
	@NotBlank(message = "campo requerido")
	private String license;
	@NotBlank(message = "campo requerido")
    @Size(min = 8)
	private String Password;
	
	public TherapistDTO() {
		
	}

	
	
	public TherapistDTO(Long id, String name, String email, String cpf, LocalDate birthDate, String uriPhoto, List<Role> roles, String license,String Password) {
		super(id, name, email, cpf, birthDate, uriPhoto, roles);
		this.license = license;
		this.Password = Password;
	}



	public TherapistDTO(Therapist entity) {
		super(entity.getId(), entity.getName(), entity.getEmail(), entity.getCpf(), entity.getBirthDate(), entity.getUriPhoto());
		this.license = entity.getLicense();
		this.Password = entity.getPassword();
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



	public String getPassword() {
		return Password;
	}



	public void setPassword(String password) {
		Password = password;
	}
	
}
