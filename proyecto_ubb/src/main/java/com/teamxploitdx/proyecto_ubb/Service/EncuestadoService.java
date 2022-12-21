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

    /**
    Encuentra a todos los encuestados
    */    
    public List<Encuestado> findAllEncuestados() {
        return encuestadoRepository.findAll();
    }
    
    /**
    Encuentra un encuestado por id
    @param id El id del encuestado
    */  
    public Optional<Encuestado> findEncuestadoById(int id){
    	return encuestadoRepository.findById(id);
    }
    
    /**
    Encuentra una categoria por id
    @param id El id de la categoria
    */  
    public Optional<Categoria> findCategoriaById(int id){
    	return categoriaRepository.findById(id);
    }
    
    /**
    Agrega un nuevo Encuestado
    @param Encuestado El encuestado a agregar al repositorio
    */  
	public boolean save(Encuestado encuestado) {
        Optional<Encuestado> encuestadoOptional = encuestadoRepository.findEncuestadoByNombre(encuestado.getNombre());
        if(encuestadoOptional.isEmpty()) {
        	encuestadoRepository.saveAndFlush(encuestado);
        	encuestadoOptional = encuestadoRepository.findEncuestadoByNombre(encuestado.getNombre());
            return encuestadoOptional.isPresent();
        } else {
            return false;
        }
	}
	
	/*Agrega una preferencia*/
	public boolean addPreferencia(int encId, int catId) {
		Optional<Encuestado> enc = encuestadoRepository.findById(encId);
		Optional<Categoria> cat = categoriaRepository.findById(catId);
		
		if(enc.isPresent()) {													//evalua si existe el encuestado
			if(cat.isPresent()) { 												//evalua si existe la categoria
				List<Categoria> preferencias = enc.get().getPreferencias();		
				if(!preferencias.contains(cat.get())) {							//evalua si no existe la categoria dentro de las preferencias 
					enc.get().addPreferencias(cat.get());						//si no existe, entonces la agrega
					encuestadoRepository.saveAndFlush(enc.get());
					return true;
				}else {															//si existe, no la agrega
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
		List<Categoria> preferencias = enc.get().getPreferencias();
		
		if(enc.isPresent()) {													//evalua si existe el encuestado
			if(cat.isPresent()) {												//evalua si existe la categoria
				if(!preferencias.contains(cat.get())) {							//evalua si no existe la categoria dentro de las preferencias
					return false;												//si no existe, no hace anda
				}else {
					preferencias.remove(cat.get());								//si existe la elimina y guarda la lista de preferencias 
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