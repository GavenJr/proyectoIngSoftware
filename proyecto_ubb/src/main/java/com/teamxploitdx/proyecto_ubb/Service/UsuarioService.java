package com.teamxploitdx.proyecto_ubb.Service;

import java.util.Optional;
import java.util.List;
import org.springframework.stereotype.Service;

import com.teamxploitdx.proyecto_ubb.Model.Rol;
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
    public boolean save(Usuario usuario) {
    	UsuarioRepository.save(usuario);
    	Optional<Usuario> usuarioOptional = UsuarioRepository.findUsuarioById(usuario.getIdUsuario());
    	return usuarioOptional.isPresent();
    }

    public List<Usuario> findAllUsuarios(){
    	return UsuarioRepository.findAll();
    }

    //funcion para asignar un rol a un usuario
    public boolean asignarRol(int idUsuario, int idRol) {
    	Optional<Usuario> usuarioOptional = UsuarioRepository.findUsuarioById(idUsuario);
    	Optional<Rol> rolOptional = RolRepository.findRolById(idRol);
    	if(usuarioOptional.isPresent() && rolOptional.isPresent()) {
    		Usuario usuario = usuarioOptional.get();
    		Rol rol = rolOptional.get();
    		usuario.setRol(rol);
    		UsuarioRepository.save(usuario);
    		return true;
    	}
    	return false;
    }
}