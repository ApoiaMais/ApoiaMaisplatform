package com.apoiamais.platform.controllers.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private List<FieldMessage> erros = new ArrayList<>();
	
	public ValidationError(Instant timestamp, Integer status, String message, String error, String path) {
		super(timestamp, status, message, error, path);
	}

	public List<FieldMessage> getErros() {
		return erros;
	}
	
	public void addError(String fieldName, String message) {
		erros.add(new FieldMessage(fieldName, message));
	}
	

}
