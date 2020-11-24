package com.matheusf.project.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusf.project.domain.Avaliacao;
import com.matheusf.project.domain.repositories.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Autowired
	private TurmaService turmaService;

	public Avaliacao insert(Avaliacao avali) {
		return avaliacaoRepository.save(avali);		
	}

	public List<Avaliacao> findByIdTurma(Integer id) {
		turmaService.findById(id);
		return avaliacaoRepository.findTurmas(id);
	}
	
	
}
