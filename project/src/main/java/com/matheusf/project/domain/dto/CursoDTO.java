package com.matheusf.project.domain.dto;

import java.util.ArrayList;
import java.util.List;

import com.matheusf.project.domain.Curso;
import com.matheusf.project.domain.Turma;

public class CursoDTO {
	
	private Integer id;
	private String nome;
	private Integer cargaHoraria;
	private Double valor;
	private Double notaPrevista;
	private Double notaMinima;
	private List<Turma> turmas = new ArrayList<>();	
	
	public CursoDTO() {
	}
	
	public CursoDTO(Curso curso) {
		id = curso.getId();
		nome = curso.getNome();
		cargaHoraria = curso.getCargaHoraria();
		valor = curso.getValor();
		notaPrevista = curso.getNotaPrevista();
		notaMinima = curso.getNotaMinima();
		turmas = curso.getTurmas();
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public Double getValor() {
		return valor;
	}

	public Double getNotaPrevista() {
		return notaPrevista;
	}

	public Double getNotaMinima() {
		return notaMinima;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}
}