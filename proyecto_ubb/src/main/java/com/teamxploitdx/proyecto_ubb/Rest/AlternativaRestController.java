package com.teamxploitdx.proyecto_ubb.Rest;

import java.util.List;

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

import com.teamxploitdx.proyecto_ubb.Model.Alternativa;
import com.teamxploitdx.proyecto_ubb.Model.Pregunta;
import com.teamxploitdx.proyecto_ubb.Service.AlternativaService;

@RestController     // definimos que es un controlador
@RequestMapping(value = "alternativa", produces = "application/json")  // Usamos la notacion json para obtener resultados en esa URI
public class AlternativaRestController {
	    private AlternativaService alternativaService;
	    
	    public AlternativaRestController (AlternativaService alternativaService) {
	    	this.alternativaService = alternativaService;
	    }
	    
	    /**
	    Busca todos las alternativas y las muestra
	    */    
	    @GetMapping(value = "")
	    public ResponseEntity<List<Alternativa>> getAllAlternativas() {
	        List<Alternativa> alternativaList = alternativaService.findAllAlternativas();
	        if (!alternativaList.isEmpty()) {
	            return new ResponseEntity<>(alternativaList, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    /**
	    Agrega una nueva alternativa
	    @param alternativa La alternativa a agregar
	    */  
	    @PostMapping(value = "")
	    public ResponseEntity<Void> addAlternativa(@RequestBody Alternativa alternativa) {
	        boolean nuevo = alternativaService.save(alternativa);
	        if (nuevo) {
	            return new ResponseEntity<>(HttpStatus.CREATED);
	        } else {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }
	    
	    @PutMapping (value = "/editarAlternativa/{idAlt}/{newTexto}")
	    public ResponseEntity<Void> editarAlternativa (@PathVariable (value = "idAlt") int idAlt, 
	    											   @PathVariable (value = "newTexto") String newTexto){
	        boolean edit = alternativaService.editAlternativa(idAlt, newTexto);
	        if(edit){
	            return new ResponseEntity<>(HttpStatus.OK);
	        }else{
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }
	    
	    @DeleteMapping(value = "/elimina/{altId}")
	    public ResponseEntity<Void> deleteAlternativa(@PathVariable(value = "altId") int alternativaId) {
	    	boolean eliminado = alternativaService.deleteAlternativaById(alternativaId);
	    	if(eliminado) {
	    		return new ResponseEntity<>(HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	    }

	/**
     * Elimina todas las alternativas de una pregunta
     * @param idPregunta el id de la pregunta que esta siendo eliminada
     * @return 200 si se elimino, 409 si hubo un problema en la operacion, 404 si no se encontro
     */
		@DeleteMapping(value = "deleteAll/{idPregunta}")
		public ResponseEntity<Void> deleteAllFromPregunta(int idPregunta){
			List<Alternativa> alternativaList = alternativaService.findAll(idPregunta);
			if(!alternativaList.isEmpty()){
				// Llamamos a que se eliminen sus respuestas?
				
				for(Alternativa alternativa : alternativaList){
					if( !alternativaService.deleteAlternativaById( alternativa.getId() ) ){
						// Si no se elimina alguna, tira conflicto
						return new ResponseEntity<>(HttpStatus.CONFLICT);
					}
				}
				// Si no, todo en orden!
				return new ResponseEntity<>(HttpStatus.OK);
				
			}
			System.out.println("No se ha encontrado ninguna alternativa para la pregunta con el id: "+idPregunta);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
}
