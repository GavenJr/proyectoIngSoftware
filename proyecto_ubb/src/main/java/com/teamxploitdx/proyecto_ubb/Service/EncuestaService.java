package com.teamxploitdx.proyecto_ubb.Service;
// imports de Java
import java.util.*;
// imports de spring boot
import org.springframework.stereotype.Service;
// imports locales
import com.teamxploitdx.proyecto_ubb.Model.Encuesta;
import com.teamxploitdx.proyecto_ubb.Repository.EncuestaRepository;

@Service
public class EncuestaService {
    EncuestaRepository encuestaRepository;                      // 

    public EncuestaService(EncuestaRepository encuestaRepository) {
        this.encuestaRepository = encuestaRepository;           // Con esto, sera posible hacer las asignaciones con el repositorio
    }
    
    public List<Encuesta> findAllEncuestas(){
        return encuestaRepository.findAll();
    }

 
    public Optional<Encuesta> findEncuestaById(int id){
        return encuestaRepository.findById(id);
    }

    public boolean updateVisibilidad (int idEncuesta, Boolean newVisi){
        
        Optional<Encuesta> encuestaOptional = encuestaRepository.findById(idEncuesta);
        Encuesta encuesta = encuestaOptional.get();
        
        if (encuestaOptional.isPresent()){
            encuesta.setVisibilidad(newVisi);
            encuestaRepository.save(encuesta);
                return true;
            }else{
                return false;
            }
    }

}
