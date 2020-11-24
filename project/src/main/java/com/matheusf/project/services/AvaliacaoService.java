package com.matheusf.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusf.project.domain.Avaliacao;
import com.matheusf.project.repositories.AvaliacaoRepository;
import com.matheusf.project.service.exceptions.DoMainException;

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

	public Avaliacao findAlunos(Integer idAvaliacao) {	
		Optional<Avaliacao> opt = avaliacaoRepository.findById(idAvaliacao);
		if (!opt.isPresent()) {
			throw new DoMainException("Avaliação de id " + idAvaliacao + " não encontrada");
		}
		return opt.get();
	}		
}
