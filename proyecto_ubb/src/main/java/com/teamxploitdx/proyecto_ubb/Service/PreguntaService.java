package com.teamxploitdx.proyecto_ubb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teamxploitdx.proyecto_ubb.Model.Encuesta;
import com.teamxploitdx.proyecto_ubb.Model.Pregunta;
import com.teamxploitdx.proyecto_ubb.Repository.EncuestaRepository;
import com.teamxploitdx.proyecto_ubb.Repository.PreguntaRepository;

@Service
public class PreguntaService {
    private final PreguntaRepository preguntaRepository;
    private final EncuestaRepository encuestaRepository;

    public PreguntaService (PreguntaRepository preguntaRepository, EncuestaRepository encuestaRepository){
        this.preguntaRepository = preguntaRepository;
        this.encuestaRepository = encuestaRepository;
    }

    public List <Pregunta> findAllPreguntas (){
        return preguntaRepository.findAll();
    }

    public Optional<Pregunta> findPreguntaById(int preguntaId){
        return preguntaRepository.findById(preguntaId);
    }

    public boolean AddPregunta (Pregunta pregunta){

        Optional <Pregunta> preg = preguntaRepository.findById(pregunta.getId());
        Optional <Encuesta> enc = encuestaRepository.findById(pregunta.getEncuesta().getId()); 

        if (!enc.isEmpty()){
            preguntaRepository.saveAndFlush(pregunta);
            preg = preguntaRepository.findById(pregunta.getId());
            return preg.isPresent();
        }else{
            return false;
        }
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

    public boolean editPregunta (String texto, int idPregunta){
        Optional<Pregunta> preg = preguntaRepository.findById(idPregunta);
        if (preg.isPresent()){
            preg.get().setTexto(texto);
            preguntaRepository.saveAndFlush(preg.get());
            return true;
        }else{
            return false;}
    }
}
