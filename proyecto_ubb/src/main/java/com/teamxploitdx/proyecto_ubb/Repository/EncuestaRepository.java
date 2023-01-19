package com.teamxploitdx.proyecto_ubb.Repository;
import java.util.List;
import java.util.Optional;

// imports de spring boot
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamxploitdx.proyecto_ubb.Model.Empresa;
// imports locales
import com.teamxploitdx.proyecto_ubb.Model.Encuesta;

@Repository     // indicamos que es un repositorio
public interface EncuestaRepository extends JpaRepository<Encuesta, Integer>{   // Pasamos nombre de entidad y tipo de clave primaria
                                                            // JpaRepository tiene consultas basicas pre-hechas
    
    List<Encuesta> findByEmpresa(Optional<Empresa> empresa);    // buscamos encuestas por empresa
    Optional<Encuesta> findByNombre(String nombre);
    List<Encuesta> findByVisible(Optional<Encuesta> encuesta);

    List<Encuesta> findAllEncuestaByEmpresaId(int empresa);
}
