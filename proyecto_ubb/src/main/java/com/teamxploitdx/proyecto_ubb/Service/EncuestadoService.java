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
		encuestadoRepository.saveAndFlush(encuestado);
        Optional<Encuestado> encuestadoOptional = encuestadoRepository.findEncuestadoByNombre(encuestado.getNombre());
        return encuestadoOptional.isPresent();
	}
	
    /**
    Agrega una preferencia
    @param Encuestado El encuestado a modificar
    @param Categoria La preferencia a agregar
    */  
	public boolean addPreferencia(Encuestado enc, Categoria categoria) {
		if(categoria == null) {
			return false;
		}else {
			enc.addPreferencias(categoria);
			encuestadoRepository.saveAndFlush(enc);
			return true;
		}
	}
	
    /**
    Elimina una preferencia
    @param int El id de la preferencia
    @param Encuestado El encuestado del que se desea eliminar
    */  
	public boolean deletePreferenciaById(int idCat, Encuestado enc) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(idCat);
        if (categoriaOptional.isPresent()) {
            List<Categoria> preferencias = enc.getPreferencias();
            preferencias.remove(categoriaOptional.get());
            enc.setPreferencias(preferencias);
            encuestadoRepository.saveAndFlush(enc);
            return true;
        } else {
            return false;
        }
    }
	
}