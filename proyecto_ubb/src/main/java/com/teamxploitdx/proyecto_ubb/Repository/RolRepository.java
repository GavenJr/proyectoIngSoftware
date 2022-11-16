package com.teamxploitdx.proyecto_ubb.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.teamxploitdx.proyecto_ubb.Model.Rol;


@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
	Optional<Rol> findRolByNombre(String nombre);
	Optional<Rol> findRolById(Integer id);
}