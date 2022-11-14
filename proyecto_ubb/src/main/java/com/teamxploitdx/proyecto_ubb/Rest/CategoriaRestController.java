package com.teamxploitdx.proyecto_ubb.Rest;


import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamxploitdx.proyecto_ubb.Model.Categoria;
import com.teamxploitdx.proyecto_ubb.Model.Encuestado;
import com.teamxploitdx.proyecto_ubb.Service.CategoriaService;

@RestController
@RequestMapping(value = "categoria/",produces = "application/json")
public class CategoriaRestController{
	private CategoriaService categoriaService;
	
	public CategoriaRestController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	 
}
	