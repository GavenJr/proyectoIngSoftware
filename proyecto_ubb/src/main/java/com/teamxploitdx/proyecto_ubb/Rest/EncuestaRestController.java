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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

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
    Retorna todas las encuestas a la uri "/proyecto_ubb/encuestas"
    */    
    @GetMapping(value = "")
    public ResponseEntity< List<Encuesta> > getAllEncuestas(){
        // Busca las encuestas
        List<Encuesta> encuestaList = encuestaService.findAllEncuestas();
        // Comprueba si se encontro alguna
        if( !encuestaList.isEmpty() ){
            return new ResponseEntity<>(encuestaList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
    Retorna las encuestas de una empresa (por nombre) a la URI "proyecto_ubb/encuestas/empresa?nombre="
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

    /**
    Actualiza la visibilidad de una encuesta segun su ID
    @param int El id de la encuesta
    @param boolean La visibilidad deseada
    */
    @PatchMapping (value = "/{cambiarVisibilidad}")
    public ResponseEntity<Void> changeVisibilidad (@PathVariable int idEncuesta,@PathVariable boolean newVis){
        boolean actualizado = encuestaService.updateVisibilidad(idEncuesta, newVis );
          if(actualizado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

      /**
    Actualiza el maximo de personas que responden una encuesta 
    @param int El id de la encuesta , se envia atraves de la url  /proyecto_ubb/encuestas/cambiarMaximo/2
    @param json encuesta representa el modelo encuesta y se envia el nuevo valor de la maximo de respuestas de
    la encuesta de la siguiente forma a traves del body de la petición
        {"max_respuestas":58 } 
    */

    @PatchMapping (value = "/cambiarMaximo/{idEncuesta}")
    public ResponseEntity<Void> changeMaximoEncuesta (@PathVariable int idEncuesta,@RequestBody Encuesta encuesta){
        boolean actualizado = encuestaService. updateMaxRespuestas(idEncuesta, encuesta.getMax_respuestas() );
          if(actualizado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

     /**
    Actualiza el minimo de personas que responden una encuesta 
    @param int El id de la encuesta , se envia atraves de la url  /proyecto_ubb/encuestas/cambiarMinimo/2
    @param json encuesta representa el modelo encuesta y se envia el nuevo valor de la minimo de respuestas de
    la encuesta de la siguiente forma a traves del body de la petición
        {"min_respuestas":58 } 
    */

    @PatchMapping (value = "/cambiarMinimo/{idEncuesta}")
    public ResponseEntity<Void> changeMinimoEncuesta (@PathVariable int idEncuesta,@RequestBody Encuesta encuesta){
        boolean actualizado = encuestaService.updateMinRespuestas(idEncuesta, encuesta.getMin_respuestas() );
          if(actualizado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
