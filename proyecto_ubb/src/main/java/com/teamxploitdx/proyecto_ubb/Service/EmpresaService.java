package com.teamxploitdx.proyecto_ubb.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teamxploitdx.proyecto_ubb.Model.Empresa;
import com.teamxploitdx.proyecto_ubb.Repository.EmpresaRepository;

@Service    //definimos el servicio
public class EmpresaService {
    
    private final EmpresaRepository empresaRepository;


    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    /**
    Encuentra todas las Empresas y las devuelve
    */  
    public List<Empresa> findAllEmpresas(){
        return empresaRepository.findAll();
    }
}
