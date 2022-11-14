package com.teamxploitdx.proyecto_ubb.Rest;
// imports de Java
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// imports de spring boot
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// imports locales
import com.teamxploitdx.proyecto_ubb.Model.Encuesta;
import com.teamxploitdx.proyecto_ubb.Service.EncuestaService;

@RestController     // definimos que es un controlador
@RequestMapping(value = "encuestas", produces = "application/json")  // Usamos la notacion json para obtener resultados en esa URI
public class EncuestaRestController {

    @Autowired      // Hacemos un auto-conectado
    EncuestaService encuestaService;

    public EncuestaRestController(EncuestaService encuestaService) {
        this.encuestaService = encuestaService;
    }

    /**
    Retorna todas las encuestas
    */    
    @GetMapping(value = "")
    public ResponseEntity< List<Encuesta> > getAllEncuestas(){
        List<Encuesta> encuestaList = encuestaService.findAllEncuestas();
        if( !encuestaList.isEmpty() ){
            return new ResponseEntity<>(encuestaList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
    Retorna las encuestas segun el nombre de una empresa
    @param String El nombre de la empresa
    */
    @GetMapping(value = "/empresa")       //RequestParam extrae el parametro name de la query
    public ResponseEntity< List<Encuesta> > getEncuestasByEmpresa(@RequestParam String nombre){

        List<Encuesta> encuestaList = encuestaService.findByEmpresa(nombre);
        // Revisamos si hay encuestas en esa empresa
        if( !encuestaList.isEmpty() ){
            return new ResponseEntity<List<Encuesta>>(encuestaList, HttpStatus.OK);
        }else{
            return new ResponseEntity<List<Encuesta>>(encuestaList, HttpStatus.NOT_FOUND);
        }

    }



    @PatchMapping (value = "/{cambiarVisibilidad}")
    public ResponseEntity<Void> changeVisibilidad (@PathVariable int idEncuesta,@PathVariable boolean newVis){
        boolean actualizado = encuestaService.updateVisibilidad(idEncuesta, newVis );
          if(actualizado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
