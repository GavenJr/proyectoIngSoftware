package com.teamxploitdx.proyecto_ubb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teamxploitdx.proyecto_ubb.Model.Encuestado;
import com.teamxploitdx.proyecto_ubb.Repository.EncuestadoRepository;

@Service
public class EncuestadoService {
	private final EncuestadoRepository encuestadoRepository;

    public EncuestadoService(EncuestadoRepository encuestadoRepository) {
        this.encuestadoRepository = encuestadoRepository;
    }

    public List<Encuestado> findAllEncuestados() {
        return encuestadoRepository.findAll();
    }
    
    /*Agrega un nuevo Encuestado*/
	public boolean save(Encuestado encuestado) {
		encuestadoRepository.saveAndFlush(encuestado);
        Optional<Encuestado> encuestadoOptional = encuestadoRepository.findEncuestadoByNombre(encuestado.getNombre());
        return encuestadoOptional.isPresent();
	}
}