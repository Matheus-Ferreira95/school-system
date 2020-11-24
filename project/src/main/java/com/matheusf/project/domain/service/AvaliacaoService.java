package com.matheusf.project.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusf.project.domain.Avaliacao;
import com.matheusf.project.domain.repositories.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;

	public Avaliacao insert(Avaliacao avali) {
		return avaliacaoRepository.save(avali);		
	}
	
	
}
