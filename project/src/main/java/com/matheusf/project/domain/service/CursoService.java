package com.matheusf.project.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusf.project.domain.Curso;
import com.matheusf.project.domain.dto.CursoDTO;
import com.matheusf.project.domain.repositories.CursoRepository;
import com.matheusf.project.domain.service.exceptions.ResourceNotFoundException;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public List<CursoDTO> findAll() {
		return cursoRepository.findAll().stream()
				.map(curso -> new CursoDTO(curso))
				.collect(Collectors.toList());
	}	
	
	public CursoDTO findById(Integer id) {
		Optional<Curso> opt = cursoRepository.findById(id);
		if (opt.isPresent()) {
			return new CursoDTO(opt.get());
		}
		throw new ResourceNotFoundException("Curso com id " + id + " não encontrado");
	}
	
}