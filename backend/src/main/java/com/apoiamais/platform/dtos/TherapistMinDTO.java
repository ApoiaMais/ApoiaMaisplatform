package com.apoiamais.platform.dtos;

import com.apoiamais.platform.entities.Therapist;

public class TherapistMinDTO extends UserDTO {
	
	private String cpf;
	private String uriPhoto;
	private String license;
	
	public TherapistMinDTO() {
		
	}

	public TherapistMinDTO(Long id, String name, String email, String cpf, String uriPhoto,
			String license) {
		super(id, name, email, null);
		this.cpf = cpf;
		this.uriPhoto = uriPhoto;
		this.license = license;
	}
	
	public TherapistMinDTO(Therapist entity) {
		super(entity.getId(), entity.getName(), entity.getEmail(), null);
		this.cpf = entity.getCpf();
		this.uriPhoto = entity.getUriPhoto();
		this.license = entity.getLicense();
	}
	
	public TherapistMinDTO(TherapistDTO dto) {
		super(dto.getId(), dto.getName(), dto.getEmail(), null);
		this.cpf = dto.getCpf();
		this.uriPhoto = dto.getUriPhoto();
		this.license = dto.getLicense();
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
