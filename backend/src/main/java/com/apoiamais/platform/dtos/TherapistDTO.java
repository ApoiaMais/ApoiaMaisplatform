package com.apoiamais.platform.dtos;

import com.apoiamais.platform.entities.Therapist;

public class TherapistDTO extends UserDTO {
	
	private String cpf;
	private String uriPhoto;
	private String license;
	
	public TherapistDTO() {
		
	}

	public TherapistDTO(Long id, String name, String email, String password, String cpf, String uriPhoto,
			String license) {
		super(id, name, email, password);
		this.cpf = cpf;
		this.uriPhoto = uriPhoto;
		this.license = license;
	}
	
	public TherapistDTO(Therapist entity) {
		super(entity.getId(), entity.getName(), entity.getEmail(), entity.getPassword());
		this.cpf = entity.getCpf();
		this.uriPhoto = entity.getUriPhoto();
		this.license = entity.getLicense();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUriPhoto() {
		return uriPhoto;
	}

	public void setUriPhoto(String uriPhoto) {
		this.uriPhoto = uriPhoto;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}
	
	
	
	
}
