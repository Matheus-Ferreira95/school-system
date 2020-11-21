package com.matheusf.project.domain.dto;

import java.util.ArrayList;
import java.util.List;

import com.matheusf.project.domain.Curso;
import com.matheusf.project.domain.Turma;

public class CursoTurmaDTO extends CursoDTO{
	
	private List<Turma> turmas = new ArrayList<>();

	public CursoTurmaDTO() {		
	}

	public CursoTurmaDTO(Curso curso) {
		super(curso);
		turmas = curso.getTurmas();
	}

	public List<Turma> getTurmas() {
		return turmas;
	}	
}
