package com.teamxploitdx.proyecto_ubb.Rest;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamxploitdx.proyecto_ubb.Model.Empresa;
import com.teamxploitdx.proyecto_ubb.Model.Usuario;
import com.teamxploitdx.proyecto_ubb.Service.UsuarioService;


@RestController     // definimos que es un controlador
@RequestMapping(value = "usuarios", produces = "application/json")  // Usamos la notacion json para obtener resultados en esa URI
public class UsuarioRestController {
    
    @Autowired      // Hacemos un auto-conectado
    UsuarioService usuarioService;

    public UsuarioRestController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
    Retorna todas las encuestas a la uri "/proyecto_ubb/usuarios"
    */    
    @GetMapping(value = "")
    public ResponseEntity  <List<Usuario> > getAllUsuarios(){
        // Busca los usuarios
        List<Usuario> usuarioList = usuarioService.findAllusuarios();
        // Comprueba si se encontro alguna
        if( !usuarioList.isEmpty() ){
            return new ResponseEntity<>(usuarioList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
        /**
    Agrega una una empresa al usuario
    @param usuarioId El id del usuario a actualizar
    @param idEmpresa Empresa que se agregara a usuario
    */ 
    @PostMapping(value = "/addEmpresa/{usuarioId}/empresa/{idEmpresa}")
    public ResponseEntity<Void> addEmpresa(@PathVariable (value = "usuarioId") int usuarioId, @PathVariable (value = "idEmpresa") int idEmpresa) {
    		boolean resultado = usuarioService.AddEmpresa(usuarioId,idEmpresa);
    		if(resultado) {
        		return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
    		
    }
}
