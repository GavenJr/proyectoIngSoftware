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
	public boolean addPreferencia(Encuestado enc, Categoria categoria) {
		if(categoria == null) {
			return false;
		}else {
			enc.addPreferencias(categoria);
			encuestadoRepository.saveAndFlush(enc);
			return true;
		}
	}
	
	/*Elimina una preferencia*/
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