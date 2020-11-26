package com.matheusf.project.resources;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheusf.project.domain.Avaliacao;
import com.matheusf.project.domain.dto.AvaliacaoDTO;
import com.matheusf.project.domain.dto.AvaliacaoInsertDTO;
import com.matheusf.project.services.AvaliacaoService;

@RestController
@RequestMapping(value = "/avaliacoes")
public class AvaliacaoResource {

	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@GetMapping("/{idTurma}")
	public ResponseEntity<List<AvaliacaoDTO>> findByIdTurma(@PathVariable Integer idTurma) {
		List<Avaliacao> list = avaliacaoService.findByIdTurma(idTurma);
		List<AvaliacaoDTO> listDTO = list.stream().map(x -> new AvaliacaoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody AvaliacaoInsertDTO dto) throws ParseException {
		Avaliacao avali = toEntity(dto);
		avali = avaliacaoService.insert(avali);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(avali.getId()).toUri();
		return ResponseEntity.created(uri).build();		
	}
	
	@GetMapping("/lista/{idAvaliacao}")
	public ResponseEntity <List<String>> findAlunos(@PathVariable Integer idAvaliacao){
			Avaliacao avali = avaliacaoService.findAlunos(idAvaliacao);
			List<String> nomes = avali.getAlunos();							
			return ResponseEntity.ok().body(nomes);		
	}

	private Avaliacao toEntity(@Valid AvaliacaoInsertDTO dto) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Avaliacao avali = new Avaliacao();
		avali.setData(sdf.parse(dto.getData()));
		avali.setId(null);
		avali.setNota(dto.getNota());
		avali.setTurma(dto.getTurma());
		return avali;
	}
}
