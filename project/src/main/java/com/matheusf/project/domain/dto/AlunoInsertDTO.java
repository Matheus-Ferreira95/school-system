package com.matheusf.project.domain.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

import com.matheusf.project.domain.Matricula;

public class AlunoInsertDTO {
	
	@NotNull
	@CPF
	private String cpf;
	
	@NotNull
	private String nome;
	
	@NotNull
	@Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "deve estar no formato dd/MM/yyyy")
	private String nascimento;
	
	private Matricula matricula;
		
	public AlunoInsertDTO() {
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}	
}