package com.matheusf.project.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheusf.project.domain.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer>{

	Turma findByNumero(Integer numero);
}
