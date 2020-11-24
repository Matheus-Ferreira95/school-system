package com.matheusf.project.domain.resources;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheusf.project.domain.Aluno;
import com.matheusf.project.domain.dto.AlunoInsertDTO;
import com.matheusf.project.domain.service.AlunoService;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService alunoService;
	
	@Transactional
	@PostMapping
	public ResponseEntity<Void> matricular(@Valid @RequestBody AlunoInsertDTO dto) throws ParseException {
		Aluno entity = toEntity(dto);		
		entity = alunoService.matricular(entity, dto.getMatricula());		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).build();		
	}

	private Aluno toEntity(AlunoInsertDTO dto) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Aluno aluno = new Aluno();
		aluno.setCpf(dto.getCpf());		
		aluno.setNome(dto.getNome());
		aluno.setNascimento(sdf.parse(dto.getNascimento()));		
		return aluno;		
	}
}
