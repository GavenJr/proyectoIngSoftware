package com.teamxploitdx.proyecto_ubb.Repository;
// imports de spring boot
import org.springframework.data.jpa.repository.JpaRepository;
// imports locales
import com.teamxploitdx.proyecto_ubb.Model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
    
}
