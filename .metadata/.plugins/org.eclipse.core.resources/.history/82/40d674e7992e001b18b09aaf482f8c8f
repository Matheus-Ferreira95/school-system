package com.matheusf.project.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matheusf.project.domain.Curso;
import com.matheusf.project.domain.dto.CursoDTO;
import com.matheusf.project.domain.dto.CursoTurmaDTO;
import com.matheusf.project.domain.dto.CursoUpdateDTO;
import com.matheusf.project.repositories.CursoRepository;
import com.matheusf.project.service.exceptions.DoMainException;
import com.matheusf.project.service.exceptions.ResourceNotFoundException;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public List<CursoTurmaDTO> findAll() {
		return cursoRepository.findAll().stream()
				.map(curso -> new CursoTurmaDTO(curso))
				.collect(Collectors.toList());
	}	
	
	public Curso findById(Integer id) {
		Optional<Curso> opt = cursoRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new ResourceNotFoundException("Curso com id " + id + " não encontrado");
	}
	
	public Curso findByName(String name) {
		return cursoRepository.findByNomeContainingIgnoreCase(name);
	}
	
	public Page<CursoDTO> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return cursoRepository.findAll(pageRequest).map(curso -> new CursoDTO(curso));
	}
	
	@Transactional
	public Curso insert(Curso curso) {
		curso.setId(null);
		return cursoRepository.save(curso);
	}	
	
	public void delete(Integer id) {
		findById(id);
		try {
			cursoRepository.deleteById(id);		
		}
		catch (DataIntegrityViolationException e) {
			throw new DoMainException("Não é possivel excluir um curso que há turmas");
		}		
	}	
	
	public void update(Integer id, CursoUpdateDTO dto) {
		Curso curso = findById(id);
		updateData(curso, dto);
		cursoRepository.save(curso);
	}

	private void updateData(Curso curso, CursoUpdateDTO dto) {
		if (dto.getNome() != null) {
			curso.setNome(dto.getNome());
		}
		if (dto.getCargaHoraria() != null) {
			curso.setCargaHoraria(dto.getCargaHoraria());
		}
		
		curso.setNotaMinima(dto.getNotaMinima());		
		curso.setValor(dto.getValor());			
	}	
}
