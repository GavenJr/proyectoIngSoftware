package com.teamxploitdx.proyecto_ubb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teamxploitdx.proyecto_ubb.Model.Alternativa;
import com.teamxploitdx.proyecto_ubb.Repository.AlternativaRepository;

@Service
public class AlternativaService {
	private AlternativaRepository alternativaRepository;
	
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
	
}
