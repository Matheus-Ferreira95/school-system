package com.matheusf.project.domain.resources.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	
	private List<FieldMessage> erros = new ArrayList<>();

	public ValidationError(Instant timeStamp, Integer status, String error, String path) {
		super(timeStamp, status, error, path);		
	}

	public List<FieldMessage> getErros() {
		return erros;
	}

	public void addErros(String campo, String mensagem) {
		erros.add(new FieldMessage(campo, mensagem));
	}
}

