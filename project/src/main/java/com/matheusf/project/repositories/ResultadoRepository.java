package com.matheusf.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.matheusf.project.domain.Resultado;
import com.matheusf.project.domain.PK.ResultadoPK;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, ResultadoPK>{
	
	@Transactional(readOnly=true)
	@Query("Select obj FROM Resultado obj WHERE obj.id.aluno.id = :idAluno AND obj.id.avaliacao.id = :idAvaliacao")
	Resultado findResultado(Integer idAluno, Integer idAvaliacao);		
}
