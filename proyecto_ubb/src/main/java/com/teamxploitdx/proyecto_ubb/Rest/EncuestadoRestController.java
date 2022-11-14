package com.teamxploitdx.proyecto_ubb.Rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamxploitdx.proyecto_ubb.Model.Categoria;
import com.teamxploitdx.proyecto_ubb.Model.Encuestado;
import com.teamxploitdx.proyecto_ubb.Service.EncuestadoService;


@RestController
@RequestMapping(value = "encuestado",produces = "application/json")
public class EncuestadoRestController {
	private EncuestadoService encuestadoService;

    public EncuestadoRestController(EncuestadoService encuestadoService) {
        this.encuestadoService = encuestadoService;
    }
    
    /**
    Busca todos los encuestados y muestra sus preferencias
    */    
    @GetMapping(value = "")
    public ResponseEntity<List<Encuestado>> getAllEncuestados() {
        List<Encuestado> encuestadoList = encuestadoService.findAllEncuestados();
        if (!encuestadoList.isEmpty()) {
            return new ResponseEntity<>(encuestadoList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /**
    Busca un encuestado especifico
    @param int El id del encuestado
    */  
    @GetMapping(value = "/{idEnc}")
    public ResponseEntity<Encuestado> getEncuestadoById(@PathVariable int idEnc) {
        Optional<Encuestado> encuestadoOptional = encuestadoService.findEncuestadoById(idEnc) ;
        if (encuestadoOptional.isPresent()) {
            return new ResponseEntity<>(encuestadoOptional.get(),  HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /**
    Agrega un encuestado nuevo
    @param Encuestado El encuestado a agregar
    */  
    @PostMapping(value = "")
    public ResponseEntity<Void> addEncuestado(@RequestBody Encuestado encuestado) {
        boolean nuevo = encuestadoService.save(encuestado);
        if (nuevo) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    /**
    Agrega una categoria a las preferencias del encuestado
    @param int El id del encuestado a actualizar
    @param Categoria La preferencia que se desea agregar al encuestado
    */ 
    @PostMapping(value = "/{encuestadoId}/categoria")
    public ResponseEntity<Void> updatePreferencias(@PathVariable(value = "encuestadoId") int encuestadoId, @RequestBody Categoria categoria) {
    	Optional<Encuestado> enc = encuestadoService.findEncuestadoById(encuestadoId);
    	if(enc.isEmpty()) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}else {
    		boolean anadido = encuestadoService.addPreferencia(enc.get(),categoria);
    		if(anadido) {
        		return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    	}	
    }
    
    /**
    Elimina una categoria de las preferencias del encuestado
    @param int El id del encuestado a actualizar
    @param Categoria La preferencia que se desea eliminar del encuestado
    */ 
    @DeleteMapping(value = "/{encuestadoId}/categoria/{categoriaId}")
    public ResponseEntity<Void> deletePreferencia(@PathVariable(value = "encuestadoId") int encuestadoId,@PathVariable(value = "categoriaId") int categoriaId) {
    	Encuestado enc = encuestadoService.findEncuestadoById(encuestadoId).get();
    	boolean eliminado = encuestadoService.deletePreferenciaById(categoriaId, enc);
    	
    	if(eliminado) {
    		return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /*
    @PostMapping(value = "/{encuestadoId}/categoria")
    public ResponseEntity<Void> updatePreferencias(@PathVariable(value = "encuestadoId") int encuestadoId, @RequestBody Categoria categoria) {
        Optional<Encuestado> encuestado = encuestadoService.findEncuestadoById(encuestadoId);
    	Optional<Categoria> categ = encuestadoService.findCategoriaById(categoria.getId());
    	
    	Encuestado enc = encuestado.get();
    	Categoria cat = categ.get();
    	
    	if(encuestado.isPresent()) {
    		if(categ.isEmpty()) {
    			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    		}else {
    			enc.addPreferencias(cat);
    			encuestadoService.save(enc);
    			return new ResponseEntity<>(HttpStatus.CREATED);
    		} 		
    	}else {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    }
    */

}
	