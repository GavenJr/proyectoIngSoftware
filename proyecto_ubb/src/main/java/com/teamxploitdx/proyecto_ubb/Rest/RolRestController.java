package com.teamxploitdx.proyecto_ubb.Rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamxploitdx.proyecto_ubb.Model.Rol;
import com.teamxploitdx.proyecto_ubb.Service.RolService;

@RestController
@RequestMapping(value = "rol/",produces = "application/json")
public class RolRestController {

    private RolService rolService;

    public RolRestController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<List<Rol>> getAllRol() {
        List<Rol> rol = rolService.findAllRol();
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Rol> addRol(@RequestBody Rol rol) {
        rolService.saveRol(rol);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable(value = "id") int id, @RequestBody Rol rol) {
        Optional<Rol> rolFound = rolService.findRolById(id);
        if (rolFound.isPresent()) {
            rol.setIdRol(id);
            rolService.saveRol(rol);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Rol> deleteRol(@PathVariable(value = "id") int id) {
        Optional<Rol> rol = rolService.findRolById(id);
        if (rol.isPresent()) {
            rolService.deleteRol(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
