package com.teamxploitdx.proyecto_ubb.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teamxploitdx.proyecto_ubb.Model.Categoria;
import com.teamxploitdx.proyecto_ubb.Model.Encuestado;
import com.teamxploitdx.proyecto_ubb.Repository.CategoriaRepository;
import com.teamxploitdx.proyecto_ubb.Repository.EncuestadoRepository;


@Service
public class EncuestadoService {
	private final EncuestadoRepository encuestadoRepository;
	private final CategoriaRepository categoriaRepository;

    public EncuestadoService(EncuestadoRepository encuestadoRepository, CategoriaRepository categoriaRepository) {
        this.encuestadoRepository = encuestadoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<Encuestado> findAllEncuestados() {
        return encuestadoRepository.findAll();
    }
    
    public Optional<Encuestado> findEncuestadoById(int id){
    	return encuestadoRepository.findById(id);
    }
    
    public Optional<Categoria> findCategoriaById(int id){
    	return categoriaRepository.findById(id);
    }
    
    /*Agrega un nuevo Encuestado*/
	public boolean save(Encuestado encuestado) {
		encuestadoRepository.saveAndFlush(encuestado);
        Optional<Encuestado> encuestadoOptional = encuestadoRepository.findEncuestadoByNombre(encuestado.getNombre());
        return encuestadoOptional.isPresent();
	}
	
	/*Agrega una preferencia*/
	public boolean addPreferencia(int encId, int catId) {
		Optional<Encuestado> enc = encuestadoRepository.findById(encId);
		Optional<Categoria> cat = categoriaRepository.findById(catId);
		
		if(enc.isPresent()) {
			if(cat.isPresent()) {
				List<Categoria> preferencias = enc.get().getPreferencias();
				if(!preferencias.contains(cat.get())) {
					enc.get().addPreferencias(cat.get());
					encuestadoRepository.saveAndFlush(enc.get());
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	/*Elimina una preferencia*/
	public boolean deletePreferenciaById(int idCat, int encId) {
		Optional<Categoria> cat = categoriaRepository.findById(idCat);
		Optional<Encuestado> enc = encuestadoRepository.findById(encId);
		
		if(enc.isPresent()) {
			if(cat.isPresent()) {
				List<Categoria> preferencias = enc.get().getPreferencias();
				if(!preferencias.contains(cat.get())) {
					return false;
				}else {
					preferencias.remove(cat.get());
					enc.get().setPreferencias(preferencias);
					encuestadoRepository.saveAndFlush(enc.get());
					return true;
				}	
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
}