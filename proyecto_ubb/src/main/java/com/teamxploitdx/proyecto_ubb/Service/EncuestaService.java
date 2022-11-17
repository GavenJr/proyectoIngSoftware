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
    private final EncuestaRepository encuestaRepository;
    private final EmpresaRepository empresaRepository;

    public EncuestaService(EncuestaRepository encuestaRepository, EmpresaRepository empresaRepository) {
        this.encuestaRepository = encuestaRepository;           // Con esto, sera posible hacer las asignaciones con el repositorio
        this.empresaRepository = empresaRepository;
    }

    /**
    Recupera todas las encuestas
    */
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
    
     /**
    Encuentra las encuestas segun el nombre de una empresa
    @param int El id de la empresa
    */
    public Optional<Encuesta> findEncuestaById(int id){
        return encuestaRepository.findById(id);
    }

    /**
    Encuentra las encuestas segun el nombre de una empresa
    @param int El id de la empresa
    @param boolean La visibilidad deseada
    */
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

    /**
    Encuentra la encuesta según el id
    @param int El id de la empresa
    @param int  Valor del nuevo maximo de encuestas 
    */

    public boolean updateMaxRespuestas (int id, int newMax){
        
        Optional<Encuesta> encuestaOptional = encuestaRepository.findById(id);
        Encuesta encuesta = encuestaOptional.get();
        
        if (encuestaOptional.isPresent()){
            encuesta.setMax_respuestas(newMax);
            encuestaRepository.save(encuesta);
                return true;
            }else{
                return false;
            }
    }

    /**
    Encuentra la encuesta según el id
    @param int El id de la empresa
    @param int  Valor del nuevo minimo
    */

    public boolean updateMinRespuestas (int id, int newMin){
        
        Optional<Encuesta> encuestaOptional = encuestaRepository.findById(id);
        Encuesta encuesta = encuestaOptional.get();
        
        if (encuestaOptional.isPresent()){
            encuesta.setMin_respuestas(newMin);
            encuestaRepository.save(encuesta);
                return true;
            }else{
                return false;
            }
    }

}
