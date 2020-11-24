package com.matheusf.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.matheusf.project.domain.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

	@Transactional(readOnly = true)
	Curso findByNomeContainingIgnoreCase(String nome);
	
}	
