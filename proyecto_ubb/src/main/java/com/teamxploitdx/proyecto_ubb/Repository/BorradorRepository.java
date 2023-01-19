package com.teamxploitdx.proyecto_ubb.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamxploitdx.proyecto_ubb.Model.Borrador;
import com.teamxploitdx.proyecto_ubb.Model.Encuesta;

@Repository
public interface BorradorRepository extends JpaRepository <Borrador, Integer>{
    List<Borrador> findAllByEncuesta(Encuesta encuesta);
}
