package com.teamxploitdx.proyecto_ubb.Rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamxploitdx.proyecto_ubb.Model.Usuario;
import com.teamxploitdx.proyecto_ubb.Service.UsuarioService;

@RestController
@RequestMapping(value = "usuario",produces = "application/json")
public class UsuarioRestController {
	private UsuarioService usuarioService;

    public UsuarioRestController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    /*Agrega un Usuario nuevo*/
    @PostMapping(value = "")
    public ResponseEntity<Void> addUsuario(@RequestBody Usuario Usuario) {
        boolean creado = usuarioService.save(Usuario);
        if (creado) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    /*Busca todos los Usuarios y muestra sus preferencias*/
    @GetMapping(value = "")
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> UsuarioList = usuarioService.findAllUsuarios();
        if (!UsuarioList.isEmpty()) {
            return new ResponseEntity<>(UsuarioList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //asignar rol a usuario 
    @PostMapping(value = "/asignarRol") 
    public ResponseEntity<Void> asignarRol(int idUsuario, int idRol) {
        boolean asignado = usuarioService.asignarRol(idUsuario, idRol);
        if (asignado) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}