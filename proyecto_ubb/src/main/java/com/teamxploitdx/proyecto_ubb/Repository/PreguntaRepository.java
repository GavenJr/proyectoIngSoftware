package com.teamxploitdx.proyecto_ubb.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamxploitdx.proyecto_ubb.Model.Pregunta;

@Repository
public interface PreguntaRepository extends JpaRepository <Pregunta, Integer> {

	List<Pregunta> findAllPreguntaByEncuestaId(int id_encuesta);



}
