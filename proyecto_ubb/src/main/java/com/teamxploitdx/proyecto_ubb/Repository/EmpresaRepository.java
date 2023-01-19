package com.teamxploitdx.proyecto_ubb.Repository;
import java.util.List;
import java.util.Optional;

// imports de spring boot
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// imports locales
import com.teamxploitdx.proyecto_ubb.Model.Empresa;
import com.teamxploitdx.proyecto_ubb.Model.Encuesta;

@Repository     //indicamos que es un repositorio
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    
    Optional<Empresa> findEmpresaByNombre(String nombre);   // Buscamos la empresa que nos interesa

    static List<Encuesta> findAllByCategoria(String categoria) {
        return null;
    }
}
