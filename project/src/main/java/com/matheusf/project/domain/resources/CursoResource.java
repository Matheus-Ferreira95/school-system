package com.matheusf.project.domain.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheusf.project.domain.Curso;
import com.matheusf.project.domain.dto.CursoDTO;
import com.matheusf.project.domain.dto.CursoTurmaDTO;
import com.matheusf.project.domain.dto.CursoUpdateDTO;
import com.matheusf.project.domain.dto.NewCursoDTO;
import com.matheusf.project.domain.service.CursoService;

@RestController
@RequestMapping(value = "/cursos")
public class CursoResource {
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping
	public ResponseEntity<List<CursoTurmaDTO>> findAll() {
		List<CursoTurmaDTO> list = cursoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{cursoId}")
	public ResponseEntity<CursoTurmaDTO> findById(@PathVariable Integer cursoId) {
		CursoTurmaDTO dto = new CursoTurmaDTO(cursoService.findById(cursoId));
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/nome")
	public ResponseEntity<CursoTurmaDTO> findByName(@RequestParam(value = "nome", defaultValue="a") String nome) {		
		Curso curso = cursoService.findByName(nome);
		CursoTurmaDTO dto = new CursoTurmaDTO(curso);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<CursoDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "1") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		
		Page<CursoDTO> list = cursoService.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);	
	}	
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody NewCursoDTO newCurso) {
		Curso curso = toEntity(newCurso);
		curso = cursoService.insert(curso);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(curso.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		cursoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody CursoUpdateDTO dto) {
		cursoService.update(id, dto);
		return ResponseEntity.ok().build();
	}

	private Curso toEntity(NewCursoDTO newCurso) {
		Curso curso = new Curso();
		curso.setNome(newCurso.getNome());
		curso.setCargaHoraria(newCurso.getCargaHoraria());
		curso.setValor(newCurso.getValor());
		curso.setNotaMinima(newCurso.getNotaMinima());
		curso.setNotaPrevista(newCurso.getNotaPrevista());
		return curso;
	}	
}
