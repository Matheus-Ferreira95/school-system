package com.matheusf.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheusf.project.domain.Resultado;
import com.matheusf.project.domain.PK.ResultadoPK;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, ResultadoPK>{

}
