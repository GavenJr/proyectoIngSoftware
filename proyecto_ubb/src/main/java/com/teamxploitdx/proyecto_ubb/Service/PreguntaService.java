package com.teamxploitdx.proyecto_ubb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teamxploitdx.proyecto_ubb.Model.Alternativa;
import com.teamxploitdx.proyecto_ubb.Model.Pregunta;
import com.teamxploitdx.proyecto_ubb.Repository.AlternativaRepository;
import com.teamxploitdx.proyecto_ubb.Repository.PreguntaRepository;

@Service
public class PreguntaService {
    private final PreguntaRepository preguntaRepository;

    public PreguntaService (PreguntaRepository preguntaRepository){
        this.preguntaRepository = preguntaRepository;
    }

    public List <Pregunta> findAllPreguntas (){
        return preguntaRepository.findAll();
    }

    public Optional<Pregunta> findPreguntasById(int preguntaId){
        return preguntaRepository.findById(preguntaId);
    }

    public boolean AddPregunta (Pregunta pregunta){

            preguntaRepository.saveAndFlush(pregunta);
            return true;
    }
    public boolean deletePregunta (int id){
        Optional<Pregunta> preg = preguntaRepository.findById(id);
        if (preg.isPresent()){
            preguntaRepository.delete(preg.get());
        return true; 
        }else {
            return false;
        }  
    }

    public boolean editPregunta (Pregunta pregunta){
        Optional<Pregunta> preg = preguntaRepository.findById(pregunta.getId());
        if (preg.isPresent()){
            preg.get().setEncuesta(pregunta.getEncuesta());
            preg.get().setId(pregunta.getId());
            preg.get().setObligatoria(pregunta.getObligatoria());
            preg.get().setOrden(pregunta.getOrden());
            preg.get().setTexto(pregunta.getTexto());
            preguntaRepository.saveAndFlush(preg.get());
            return true;
        }else{
            return false;}
    }
}
