package com.matheusf.project.domain.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.matheusf.project.domain.Avaliacao;

public class AvaliacaoDTO {

	private Double nota;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date data;	
	
	public AvaliacaoDTO(Avaliacao avali) {
		nota = avali.getNota();
		data = avali.getData();
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}	
}