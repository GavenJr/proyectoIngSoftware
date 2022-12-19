package com.teamxploitdx.proyecto_ubb.Rest;
import java.lang.StackWalker.Option;
// imports de Java
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// imports de spring boot
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.JsonMappingException;
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
            return new ResponseEntity<>(encuestaList, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
    Retorna las encuestas de una empresa (por nombre) a la URI "proyecto_ubb/encuestas/empresa?nombre=
    @param nombre El nombre de la empresa
    */
    @GetMapping(value = "/empresa")       //RequestParam extrae el parametro name de la query
    public ResponseEntity< List<Encuesta> > getEncuestasByEmpresa(@RequestParam String nombre){

        List<Encuesta> encuestaList = encuestaService.findByEmpresa(nombre);
        // Revisamos si hay encuestas en esa empresa
        if( !encuestaList.isEmpty() ){
            return new ResponseEntity<List<Encuesta>>(encuestaList, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<List<Encuesta>>(encuestaList, HttpStatus.NOT_FOUND);
        }

    }

    /**
    * Retorna la encuesta basado en su nombre a la uri "/proyecto_ubb/encuestas/encuesta?nombre="
    */    
    @GetMapping(value = "/encuesta")
    public ResponseEntity< Encuesta > getEncuestaByNombre(@RequestParam String nombre){
        // Busca las encuestas
        Optional<Encuesta> encuesta = encuestaService.findByName(nombre);
        // Comprueba si se encontro alguna
        if( encuesta.isPresent() ){
            return new ResponseEntity<>(encuesta.get(), HttpStatus.FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Crea una encuesta basado en un id de empresa creadora y nombre de encuesta, a la URI proyecto_ubb/empresa/{idEmpresa}/encuestas/agregar?nombre=
     * @param encuesta encuesta proporcionada por el Body en formato Json
     * @param nombre el nombre de la nueva encuesta
     * @return ResponseEntity de la encuesta, o un codigo de error
     */
    @PostMapping (value = "/agregar")
    public ResponseEntity< Void > crearEncuesta(@RequestBody Encuesta encuesta){
        // Primero, deberiamos comprobar si ya existe la encuesta
        Optional<Encuesta> encuestaOptional = encuestaService.findByName(encuesta.getNombre());
        if(encuestaOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.IM_USED);
        }
        // Si no, intentamos crearla
        boolean creada = encuestaService.crearEncuesta(encuesta);
        if(creada){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    /**
     * Crea una encuesta basado en un id de empresa creadora y nombre de encuesta, a la URI proyecto_ubb/empresa/{idEmpresa}/encuestas/agregar?nombre=
     * @param idEmpresa el id de la empresa
     * @param nombre el nombre de la nueva encuesta
     * @return ResponseEntity de la encuesta, o un codigo de error
     */
    @PostMapping (value = "/empresa/{idEmpresa}/agregar")
    public ResponseEntity<Encuesta> crearEncuesta(@PathVariable (value = "idEmpresa") int idEmpresa, @RequestParam String nombre){
        // Primero, deberiamos comprobar si ya existe la encuesta
        Optional<Encuesta> encuesta = encuestaService.findByName(nombre);
        if(encuesta.isPresent()){
            return new ResponseEntity<>(HttpStatus.IM_USED);
        }
        // Si no, intentamos crearla
        boolean creada = encuestaService.crearEncuesta(idEmpresa, nombre);
        if(creada){
            return new ResponseEntity<Encuesta>(HttpStatus.CREATED);
        }

        return new ResponseEntity<Encuesta>(HttpStatus.CONFLICT);
    }

     /**
    Actualiza la visibilidad de una encuesta segun su ID
    @param idEncuesta El id de la encuesta
    */
    @PatchMapping (value = "/cambiarVisibilidad/{idEncuesta}")
    public ResponseEntity<Void> changeVisibilidad (@PathVariable int idEncuesta)throws JsonMappingException{
        boolean actualizado = encuestaService.updateVisibilidad(idEncuesta);
          if(actualizado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
    Actualiza el maximo de personas que responden una encuesta 
    @param idEncuesta El id de la encuesta , se envia atraves de la url  /proyecto_ubb/encuestas/cambiarMaximo/2/100
    @param newMax El nuevo maximo de encuestados admitidos
    */

    @PatchMapping (value = "/cambiarMaximo/{idEncuesta}/{newMax}")
    public ResponseEntity<Void> changeMaximoEncuesta (@PathVariable int idEncuesta,@PathVariable int newMax){
        boolean actualizado = encuestaService.updateMaxRespuestas(idEncuesta, newMax );
          if(actualizado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
    Actualiza el minimo de personas que responden una encuesta 
    @param idEncuesta El id de la encuesta , se envia atraves de la url  /proyecto_ubb/encuestas/cambiarMinimo/2/24
    @param newMin El nuevo minimo de encuestados admitidos
    */
    @PatchMapping (value = "/cambiarMinimo/{idEncuesta}/{newMin}")
    public ResponseEntity<Void> changeMinimoEncuesta (@PathVariable int idEncuesta,@PathVariable int newMin){
        boolean actualizado = encuestaService.updateMinRespuestas(idEncuesta, newMin );
          if(actualizado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
