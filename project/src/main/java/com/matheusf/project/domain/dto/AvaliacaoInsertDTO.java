package com.matheusf.project.domain.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.matheusf.project.domain.Turma;

public class AvaliacaoInsertDTO {
	
	@NotNull
	@Max(100)
	private Double nota;
	
	@NotNull
	@Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "deve estar no formato dd/MM/yyyy")
	private String data;
	
	private Turma turma;
	
	public AvaliacaoInsertDTO() {
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}