package com.teamxploitdx.proyecto_ubb.Repository;
// imports de spring boot
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// imports locales
import com.teamxploitdx.proyecto_ubb.Model.Encuesta;

@Repository                                                 // Pasamos nombre de entidad y tipo de clave primaria
public interface EncuestaRepository extends JpaRepository<Encuesta, Integer>{
                                                            // JpaRepository tiene consultas basicas pre-hechas
    //
}
