package com.teamxploitdx.proyecto_ubb.Service;

import java.util.*;
import org.springframework.stereotype.Service;

import com.teamxploitdx.proyecto_ubb.Model.Empresa;
import com.teamxploitdx.proyecto_ubb.Model.Usuario;
import com.teamxploitdx.proyecto_ubb.Repository.EmpresaRepository;
import com.teamxploitdx.proyecto_ubb.Repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final EmpresaRepository empresaRepository;
    private final UsuarioRepository usuarioRepository;

    
    public UsuarioService(UsuarioRepository usuarioRepository,EmpresaRepository empresaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.empresaRepository = empresaRepository;
    }


    /**
    Encuentra a todos los encuestados
    */    
    public List <Usuario> findAllusuarios() {
        return usuarioRepository.findAll();
    }
    /**
    asigna la empresa a Usuario
    */ 
    public boolean AddEmpresa(int usuarioID, int empresaId) {
        Optional<Empresa> empresa = empresaRepository.findById(empresaId);
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioID);
		if(!empresa.isPresent()||!usuario.isPresent()) {
			return false;
		}else {
			usuario.get().setEmpresa(empresa.get());
			usuarioRepository.saveAndFlush(usuario.get());
			return true;
		}
	}
    public Optional<Usuario> findUsuarioById(int usuarioId){
    	return usuarioRepository.findById(usuarioId);
    }
}
