package com.teamxploitdx.proyecto_ubb.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.teamxploitdx.proyecto_ubb.Model.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	Optional<Categoria> findCategoriaByNombre(String nombre);
	Optional<Categoria> findCategoriaById(Integer id);
}