package com.teamxploitdx.proyecto_ubb.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teamxploitdx.proyecto_ubb.Model.Categoria;
import com.teamxploitdx.proyecto_ubb.Model.Encuestado;
import com.teamxploitdx.proyecto_ubb.Repository.CategoriaRepository;
import com.teamxploitdx.proyecto_ubb.Repository.EncuestadoRepository;

@Service
public class CategoriaService {
	private final CategoriaRepository categoriaRepository;
	private final EncuestadoRepository  encuestadoRepository;

    public CategoriaService(CategoriaRepository categoriaRepository, EncuestadoRepository  encuestadoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.encuestadoRepository = encuestadoRepository;
    }
	
    public Optional<Encuestado> findEncuestado (int encuestadoId) {
    	return encuestadoRepository.findById(encuestadoId);
    }
    
    public Optional<Categoria> findCategoriaById(int categoriaId){
    	return categoriaRepository.findById(categoriaId);
    }
    
}