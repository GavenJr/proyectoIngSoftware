package com.teamxploitdx.proyecto_ubb.Rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamxploitdx.proyecto_ubb.Model.Encuestado;
import com.teamxploitdx.proyecto_ubb.Service.EncuestadoService;

@RestController
@RequestMapping(value = "encuestado",produces = "application/json")
public class EncuestadoRestController {
	private EncuestadoService encuestadoService;

    public EncuestadoRestController(EncuestadoService encuestadoService) {
        this.encuestadoService = encuestadoService;
    }
    
    /*Agrega un encuestado nuevo*/
    @PostMapping(value = "")
    public ResponseEntity<Void> addEncuestado(@RequestBody Encuestado encuestado) {
        boolean creado = encuestadoService.save(encuestado);
        if (creado) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    /*Busca todos los encuestados y muestra sus preferencias*/
    @GetMapping(value = "")
    public ResponseEntity<List<Encuestado>> getAllEncuestados() {
        List<Encuestado> encuestadoList = encuestadoService.findAllEncuestados();
        if (!encuestadoList.isEmpty()) {
            return new ResponseEntity<>(encuestadoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}