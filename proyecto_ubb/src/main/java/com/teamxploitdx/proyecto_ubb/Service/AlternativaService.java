package com.teamxploitdx.proyecto_ubb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teamxploitdx.proyecto_ubb.Model.Alternativa;
import com.teamxploitdx.proyecto_ubb.Model.Pregunta;
import com.teamxploitdx.proyecto_ubb.Repository.AlternativaRepository;
import com.teamxploitdx.proyecto_ubb.Repository.PreguntaRepository;

@Service
public class AlternativaService {
	private AlternativaRepository alternativaRepository;
	private PreguntaRepository preguntaRepository;
	
	public AlternativaService (AlternativaRepository alternativaRepository) {
		this.alternativaRepository = alternativaRepository;
	}
	
	/**
    Encuentra a todos los encuestados
    */    
    public List<Alternativa> findAllAlternativas() {
        return alternativaRepository.findAll();
    }
	
	/**
    Crea una nueva alternativa
    @param Encuestado El encuestado a agregar al repositorio
    */  
	public boolean save(Alternativa alternativa) {
        Optional<Alternativa> alternativaOptional = alternativaRepository.findAlternativaById(alternativa.getId());
        if(alternativaOptional.isEmpty()) {
        	alternativaRepository.saveAndFlush(alternativa);
        	alternativaOptional = alternativaRepository.findAlternativaById(alternativa.getId());
            return alternativaOptional.isPresent();
        } else {
            return false;
        }
	}
	
	/*Edita una alternativa*/
	public boolean editAlternativa (int idAlt, String newTexto){
		Optional<Alternativa> alt = alternativaRepository.findById(idAlt);
		Alternativa alternativa = alt.get();
		String texto = alternativa.getTexto();
		if(!texto.contentEquals(newTexto)) {
			alternativa.setTexto(newTexto);
	        alternativaRepository.saveAndFlush(alternativa);
	        return true;
        }else{
        	return false;
        }
    }
	
	/*Elimina una alternativa*/
	public boolean deleteAlternativaById(int idAlt) {
		Optional<Alternativa> alt = alternativaRepository.findById(idAlt);
		if(alt.isPresent()) {
			alternativaRepository.delete(alt.get());
			return true;
		}else {
			return false;
		}
	}

	public List<Alternativa> findAll(int idPregunta){
		return alternativaRepository.findAllAlternativas( preguntaRepository.findById(idPregunta).get() );
	}
}
