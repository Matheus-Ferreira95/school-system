package com.matheusf.project.domain.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.matheusf.project.domain.Turma;

public class TurmaFindDTO {
	
	private Integer id;
	private Integer numero;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date inicio;
	private Integer vagas;
	
	public TurmaFindDTO() {
	}
	
	public TurmaFindDTO(Turma turma) {
		id = turma.getId();
		numero = turma.getNumero();
		inicio = turma.getInicio();
		vagas = turma.getVagas();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}
}