package com.matheusf.project.domain.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class NewCursoDTO {
	
	@NotBlank
	@Size(max = 80)
	private String nome;
	
	@Max(value = 140, message = "A maior carga horária permitida é de 140")
	@Min(value = 10, message = "A menor carga horária permitida é de 10")
	@NotNull
	private Integer cargaHoraria;
	
	@NotNull
	private Double valor;
	
	@NotNull
	@Range(min = 100, max = 100)
	private Double notaPrevista;
	
	@NotNull
	@Min(value = 50)
	private Double notaMinima;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getNotaPrevista() {
		return notaPrevista;
	}

	public void setNotaPrevista(Double notaPrevista) {
		this.notaPrevista = notaPrevista;
	}

	public Double getNotaMinima() {
		return notaMinima;
	}

	public void setNotaMinima(Double notaMinima) {
		this.notaMinima = notaMinima;
	}
}