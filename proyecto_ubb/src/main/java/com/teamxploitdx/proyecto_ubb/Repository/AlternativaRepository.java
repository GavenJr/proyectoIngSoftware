package com.teamxploitdx.proyecto_ubb.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamxploitdx.proyecto_ubb.Model.Alternativa;

@Repository
public interface AlternativaRepository extends JpaRepository<Alternativa, Integer>{
	
	Optional<Alternativa> findAlternativaById(Integer id);
	Optional<Alternativa> findAlternativaByTexto (String texto);
}