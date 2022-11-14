package com.teamxploitdx.proyecto_ubb.Service;
// imports de Java
import java.util.*;
// imports de spring boot
import org.springframework.stereotype.Service;

import com.teamxploitdx.proyecto_ubb.Model.Empresa;
// imports locales
import com.teamxploitdx.proyecto_ubb.Model.Encuesta;
import com.teamxploitdx.proyecto_ubb.Repository.EmpresaRepository;
import com.teamxploitdx.proyecto_ubb.Repository.EncuestaRepository;

@Service
public class EncuestaService {
    private final EncuestaRepository encuestaRepository;                      // 
    private final EmpresaRepository empresaRepository;


    public EncuestaService(EncuestaRepository encuestaRepository, EmpresaRepository empresaRepository) {
        this.encuestaRepository = encuestaRepository;           // Con esto, sera posible hacer las asignaciones con el repositorio
        this.empresaRepository = empresaRepository;
    }

    public List<Encuesta> findAllEncuestas(){
        return encuestaRepository.findAll();
    }

    /**
    Encuentra las encuestas segun el nombre de una empresa
    @param String El nombre de la empresa
    */
    public List<Encuesta> findByEmpresa(String nombre){
        // Obtenemos referencia a la empresa de interes
        Optional<Empresa> empresa = empresaRepository.findEmpresaByNombre(nombre);
        // Si no hay empresa, retornamos una lista vacia
        if(empresa.isEmpty())
            return List.of();
        // Si no, retornamos las encuestas que tengan vinculadas a esa empresa
        return encuestaRepository.findByEmpresa(empresa);
    }
    

 
    public Optional<Encuesta> findEncuestaById(int id){
        return encuestaRepository.findById(id);
    }

    public boolean updateVisibilidad (int idEncuesta, Boolean newVisi){
        
        Optional<Encuesta> encuestaOptional = encuestaRepository.findById(idEncuesta);
        Encuesta encuesta = encuestaOptional.get();
        
        if (encuestaOptional.isPresent()){
            encuesta.setVisible(newVisi);
            encuestaRepository.save(encuesta);
                return true;
            }else{
                return false;
            }
    }

}
