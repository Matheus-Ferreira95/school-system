package com.matheusf.project.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matheusf.project.domain.Curso;
import com.matheusf.project.domain.Turma;
import com.matheusf.project.repositories.TurmaRepository;
import com.matheusf.project.services.exceptions.DoMainException;
import com.matheusf.project.services.exceptions.ResourceNotFoundException;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private CursoService cursoService;	

	@Transactional
	public Turma insert(Turma turma) {
		cursoService.findById(turma.getCurso().getId());		
		return turmaRepository.save(turma);		
	}
	
	@Transactional(readOnly=true)
	public Turma findById(Integer id) {
		Optional<Turma> opt = turmaRepository.findById(id);
		if (!opt.isPresent()) {
			throw new ResourceNotFoundException("Turma com id " + id + " não encontrada");
		}
		return opt.get();
	}
	
	@Transactional
	public Page<Turma> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return turmaRepository.findAll(pageRequest);
	}

	public void checkStart(Date inicio) {
		Date now = new Date(System.currentTimeMillis());
		if (inicio.before(now)) {
			throw new DoMainException("Data de inicio inválida! Apenas datas futuras são aceitas");
		}		
	}

	public void checkNumero(Turma turma) {
		Turma entity = turmaRepository.findByNumero(turma.getNumero());
		Curso curso = cursoService.findById(turma.getCurso().getId());
		if (entity != null && entity.getCurso().getNome().equals(curso.getNome())) {
			throw new DoMainException("Já existente curso de " + curso.getNome() + " com numero " + turma.getNumero());
		}		
	}
}
