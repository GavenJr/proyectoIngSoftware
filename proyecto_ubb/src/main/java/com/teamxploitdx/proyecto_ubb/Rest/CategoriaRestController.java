package com.teamxploitdx.proyecto_ubb.Rest;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping (value = "")
	public ResponseEntity<?> addCategoria(@RequestBody Categoria categoria){
		Map<String, Object> response =new HashMap<>();
		boolean estado=false;
		try{
			if(categoria!=null){
				estado=categoriaService.saveCategoria(categoria);
				response.put("Categoria",categoria);
			}
		}catch(Exception e){
			response.put("Mensaje", "Error al realizar consulta");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);


	}
}

	