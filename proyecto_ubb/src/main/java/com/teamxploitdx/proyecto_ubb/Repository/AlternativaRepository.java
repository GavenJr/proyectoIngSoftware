package com.teamxploitdx.proyecto_ubb.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamxploitdx.proyecto_ubb.Model.Alternativa;
import com.teamxploitdx.proyecto_ubb.Model.Pregunta;

@Repository
public interface AlternativaRepository extends JpaRepository<Alternativa, Integer>{
	
	Optional<Alternativa> findAlternativaById(Integer id);
	Optional<Alternativa> findAlternativaByTexto (String texto);
	List<Alternativa> findAlternativasByPregunta(Pregunta pregunta);
	//List<Alternativa> findAlternativas(int id_pregunta);
}