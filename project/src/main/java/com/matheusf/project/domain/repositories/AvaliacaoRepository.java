package com.matheusf.project.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.matheusf.project.domain.Avaliacao;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer>{

	@Query("SELECT obj FROM Avaliacao obj where obj.turma.id = :id")
	List<Avaliacao> findTurmas(Integer id);
}
