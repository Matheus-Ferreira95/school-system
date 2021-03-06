package com.matheusf.project.domain.dto;

import java.text.SimpleDateFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.matheusf.project.domain.Curso;
import com.matheusf.project.domain.Turma;

public class TurmaDTO {
	
	@NotNull
	private Integer numero;
	
	@NotNull
	@Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "deve estar no formato dd/MM/yyyy")
	private String inicio;	
	
	@Min(10)
	private Integer vagas;
	
	private Curso curso;
	
	public TurmaDTO() {
	}
		
	public TurmaDTO(Turma turma) {	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.numero = turma.getNumero();
		this.inicio = sdf.format(turma.getInicio());
		this.vagas = turma.getVagas();		
		this.curso = turma.getCurso();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
