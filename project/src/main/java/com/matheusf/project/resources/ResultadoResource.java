package com.matheusf.project.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheusf.project.domain.Resultado;
import com.matheusf.project.services.ResultadoService;

@RestController
@RequestMapping(value="/resultados")
public class ResultadoResource {

	@Autowired
	private ResultadoService resultadoService;
	
	@PostMapping
	public ResponseEntity<Void> addResult(@RequestBody Resultado resultado) {
		Resultado entity = resultadoService.insert(resultado);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idAluno}/{idAvaliacao}")
				.buildAndExpand(entity.getAluno().getId(), entity.getAvaliacao().getId()).toUri();
		return ResponseEntity.created(uri).build();		
	}	
	
	@GetMapping(value="/{idAluno}/{idAvaliacao}")
	public ResponseEntity<Resultado> findResultado(@PathVariable Integer idAluno, @PathVariable Integer idAvaliacao) {
		Resultado entity = resultadoService.findResultado(idAluno, idAvaliacao);
		return ResponseEntity.ok().body(entity);
	}
}
