package com.matheusf.project.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.matheusf.project.domain.PK.ResultadoPK;

@Entity
@Table(name = "tb_resultado")
public class Resultado {

	@EmbeddedId
	private ResultadoPK id = new ResultadoPK();
	
	private Double notaObtida;
	
	public Resultado() {
	}

	public Resultado(Aluno aluno, Avaliacao avaliacao, Double notaObtida) {
		id.setAluno(aluno);
		id.setAvaliacao(avaliacao);
		this.notaObtida = notaObtida;
	}

	public Aluno getAluno() {
		return id.getAluno();
	}
	
	public void setAluno(Aluno aluno) {
		if (aluno != null) {
			id.setAluno(aluno);
		}			
	}
	
	public Avaliacao getAvaliacao() {
		return id.getAvaliacao();
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		if (avaliacao != null) {
			id.setAvaliacao(avaliacao);
		}
	}
	
	public Double getNotaObtida() {
		return notaObtida;
	}

	public void setNotaObtida(Double notaObtida) {
		this.notaObtida = notaObtida;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((notaObtida == null) ? 0 : notaObtida.hashCode());
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
		Resultado other = (Resultado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (notaObtida == null) {
			if (other.notaObtida != null)
				return false;
		} else if (!notaObtida.equals(other.notaObtida))
			return false;
		return true;
	}
}