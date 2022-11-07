package com.teamxploitdx.proyecto_ubb.Rest;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	/*Añade una nueva categoria a las preferencias del encuestado*/
	@PostMapping("/encuestado/{id}/preferencias")
	public ResponseEntity<Categoria>  addCategoria(@PathVariable(value = "id") int encuestadoId, @RequestBody Categoria preferencia) {
		/*Buscamos al encuestado*/
		Optional<Encuestado> encuestado = categoriaService.findEncuestado(encuestadoId);
		/*Buscamos el id de la categoria a añadir*/
		Optional<Categoria> categoria = categoriaService.findCategoriaById(preferencia.getId());
		/*Evaluamos si el encuestado existe*/
		if(encuestado.isPresent()) {
			/*Si existe, evaluamos si la categoria pedida existe*/
			if(categoria.isEmpty()){
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}else {
				/*Si existe, añadimos la categoria a las preferencias del encuestado*/
				encuestado.get().getPreferencias().add(preferencia);
				categoriaService.saveEncuestadoP(encuestado.get());
				return new ResponseEntity<>(HttpStatus.CREATED);
			}
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
	}
	  
}
	