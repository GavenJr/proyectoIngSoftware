package com.teamxploitdx.proyecto_ubb.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.teamxploitdx.proyecto_ubb.Model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	Optional<Usuario> findUsuarioByNombre(String nombre);
	Optional<Usuario> findUsuarioById(Integer id);
    Optional<Usuario> findUsuarioByApellido(String apellido);
    Optional<Usuario> findUsuarioByCorreo(String correo);
}