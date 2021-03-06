package com.matheusf.project.domain.dto;

import com.matheusf.project.domain.Curso;

public class CursoDTO {
	
	private Integer id;
	private String nome;
	private Integer cargaHoraria;
	private Double valor;
	private Double notaPrevista;
	private Double notaMinima;	
	
	public CursoDTO() {
	}
	
	public CursoDTO(Curso curso) {
		id = curso.getId();
		nome = curso.getNome();
		cargaHoraria = curso.getCargaHoraria();
		valor = curso.getValor();
		notaPrevista = curso.getNotaPrevista();
		notaMinima = curso.getNotaMinima();
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
}