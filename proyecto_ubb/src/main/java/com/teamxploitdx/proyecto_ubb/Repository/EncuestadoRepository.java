package com.teamxploitdx.proyecto_ubb.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamxploitdx.proyecto_ubb.Model.Encuestado;

@Repository
public interface EncuestadoRepository extends JpaRepository<Encuestado, Integer>{
	Optional<Encuestado> findEncuestadoByNombre(String nombre);
	
}