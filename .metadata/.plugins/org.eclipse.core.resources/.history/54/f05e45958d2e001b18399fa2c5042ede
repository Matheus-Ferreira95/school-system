package com.matheusf.project.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.matheusf.project.domain.PK.MatriculaPK;

@Entity
@Table(name="tb_matricula")
public class Matricula implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MatriculaPK id = new MatriculaPK();
	
	private Date data;
	private Integer prestacoes;
	
	public Matricula() {
	}
	
	public Matricula(Turma turma, Aluno aluno, Date data, Integer prestacoes) {	
		super();
		id.setTurma(turma);
		id.setAluno(aluno);
		this.data = data;
		this.prestacoes = prestacoes;
	}

	public Turma getTurma() {
		return id.getTurma();
	}
	
	public void setTurma(Turma turma) {
		if (turma != null) {
			id.setTurma(turma);
		}
	}

	public Aluno getAluno() {
		return id.getAluno();
	}
	
	public void setAluno(Aluno aluno) {
		if (aluno != null) {
			id.setAluno(aluno);
		}
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getPrestacoes() {
		return prestacoes;
	}

	public void setPrestacoes(Integer prestacoes) {
		this.prestacoes = prestacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}