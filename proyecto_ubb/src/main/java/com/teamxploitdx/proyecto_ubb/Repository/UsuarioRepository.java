package com.teamxploitdx.proyecto_ubb.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamxploitdx.proyecto_ubb.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
    
}
