package com.teamxploitdx.proyecto_ubb.Repository;
// imports de spring boot
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// imports locales
import com.teamxploitdx.proyecto_ubb.Model.Empresa;

@Repository     //indicamos que es un repositorio
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    
}
