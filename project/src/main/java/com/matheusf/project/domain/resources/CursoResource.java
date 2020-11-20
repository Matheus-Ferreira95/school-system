package com.matheusf.project.domain.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusf.project.domain.dto.CursoDTO;
import com.matheusf.project.domain.service.CursoService;

@RestController
@RequestMapping(value = "/cursos")
public class CursoResource {
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping
	public ResponseEntity<List<CursoDTO>> findAll() {
		List<CursoDTO> list = cursoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{cursoId}")
	public ResponseEntity<CursoDTO> findById(@PathVariable Integer cursoId) {
		CursoDTO cursoDTO = cursoService.findById(cursoId);
		return ResponseEntity.ok().body(cursoDTO);
	}
	
}
