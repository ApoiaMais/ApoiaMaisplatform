package com.apoiamais.platform.dtos;

import java.util.Date;

import jakarta.persistence.Column;

public class PatientDTO extends UserDTO {
	
	private Date birthDate;
	private String cpf;
	private String rg;
	private String nis;
}
