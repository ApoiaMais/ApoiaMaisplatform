package com.apoiamais.platform.dtos;

import java.time.LocalDate;

import com.apoiamais.platform.entities.Patient;

public class PatientMinDTO extends UserDTO {
	
	private LocalDate birthDate;
	private String cpf;
	private String rg;
	private String nis;
	
	public PatientMinDTO() {
		
	}
	
	public PatientMinDTO(Long id, String name, String email, LocalDate birthDate, String cpf,
			String rg, String nis) {
		super(id, name, email, null);
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.rg = rg;
		this.nis = nis;
	}



	public PatientMinDTO(Patient entity) {
		super(entity.getId(), entity.getName(), entity.getEmail(), null);
		this.birthDate = entity.getBirthDate();
		this.cpf = entity.getCpf();
		this.rg = entity.getRg();
		this.nis = entity.getNis();
	}
	
	public PatientMinDTO(PatientDTO dto) {
		super(dto.getId(), dto.getName(), dto.getEmail(), null);
		this.birthDate = dto.getBirthDate();
		this.cpf = dto.getCpf();
		this.rg = dto.getRg();
		this.nis = dto.getNis();
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
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

	
	
	
	
	
}
