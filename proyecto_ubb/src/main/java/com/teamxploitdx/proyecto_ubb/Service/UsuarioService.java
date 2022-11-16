package com.teamxploitdx.proyecto_ubb.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teamxploitdx.proyecto_ubb.Model.Categoria;
import com.teamxploitdx.proyecto_ubb.Model.Usuario;
import com.teamxploitdx.proyecto_ubb.Repository.UsuarioRepository;
import com.teamxploitdx.proyecto_ubb.Repository.RolRepository;


@Service
public class UsuarioService {
	private final RolRepository RolRepository;
	private final UsuarioRepository  UsuarioRepository;


    public UsuarioService(RolRepository RolRepository, UsuarioRepository  UsuarioRepository) {
        this.RolRepository = RolRepository;
        this.UsuarioRepository = UsuarioRepository;
    }
	/*
    public Optional<Usuario> findE (int encuestadoId) {
    return UsuarioRepository.findById(encuestadoId)
    }
    
    public Optional<Categoria> findCategoriaById(int categoriaId){
    	return categoriaRepository.findById(categoriaId);
    }
    
    public boolean saveEncuestadoP(Usuario encuestado) {
        UsuarioRepository.saveAndFlush(encuestado);
        Optional<Usuario> empleadoOptional =  UsuarioRepository.findEncuestadoByNombre(encuestado.getNombre());
        return empleadoOptional.isPresent();
    }
    */
    public boolean saveUsuario(Usuario usuario) {
    	UsuarioRepository.saveAndFlush(usuario);
    	Optional<Usuario> usuarioOptional = UsuarioRepository.findUsuarioByNombre(usuario.getNombre());
    	return usuarioOptional.isPresent();
    }

    public  List<Usuario> findAllUsuarios(){
    	return UsuarioRepository.findAll();
    }
}