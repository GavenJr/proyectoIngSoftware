package com.teamxploitdx.proyecto_ubb.Repository;
import java.util.List;

// imports de spring boot
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// imports locales
import com.teamxploitdx.proyecto_ubb.Model.Encuesta;

@Repository     // indicamos que es un repositorio
public interface EncuestaRepository extends JpaRepository<Encuesta, Integer>{   // Pasamos nombre de entidad y tipo de clave primaria
                                                            // JpaRepository tiene consultas basicas pre-hechas
    
    List<Encuesta> findByEmpresa(String nombre);    // Definimos los datos a recuperar segun los atributos de Encuesta

}
