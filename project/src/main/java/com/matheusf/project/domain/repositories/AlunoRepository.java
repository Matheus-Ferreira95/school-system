package com.matheusf.project.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheusf.project.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, String>{

}
