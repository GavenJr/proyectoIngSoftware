package com.teamxploitdx.proyecto_ubb.Rest;
import java.lang.StackWalker.Option;
// imports de Java
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// imports de spring boot
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    * @return 404 si no se encuentra nada, 202 si se encontraron
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
    * @param nombre El nombre de la empresa
    * @return 404 si no se encuentra nada, 202 si se encontro algo
    */
    @GetMapping(value = "/empresa")       //RequestParam extrae el parametro name de la query
    public ResponseEntity< List<Encuesta> > getEncuestasByEmpresa(@RequestParam String nombre){

        List<Encuesta> encuestaList = encuestaService.findByEmpresa(nombre);
        // Revisamos si hay encuestas en esa empresa
        if( !encuestaList.isEmpty() ){
            return new ResponseEntity<List<Encuesta>>(encuestaList, HttpStatus.FOUND);
        }else{
            return new ResponseEntity<List<Encuesta>>(HttpStatus.NOT_FOUND);
        }

    }

    /**
    * Retorna la encuesta basado en su nombre a la uri "/proyecto_ubb/encuestas/encuesta?nombre="
    * @return 404 si no se encuentra, 302 si se encuentra
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
     * Intenta crear una encuesta a la URI proyecto_ubb/encuestas/empresa/{idEmpresa}/agregar/{idEncuesta}?nombre=
     * @param nombre el nombre de la nueva encuesta pasado por Json
     * @param idEmpresa el id de la empresa pasado por Json
     * @return 226 si ya existe una encuesta por ese nombre, 201 si se creo, 409 si hubo conflicto
     */
    @PostMapping (value = "/empresa/{idEmpresa}/agregar/{idEncuesta}")
    public ResponseEntity< Void > crearEncuesta(@PathVariable (value = "idEmpresa") int idEmpresa, 
                                                @RequestParam (value = "nombre") String nombre,
                                                @PathVariable (value = "idEmpresa") int idEncuesta){
        // Primero, deberiamos comprobar si ya existe la encuesta
        Optional<Encuesta> encuestaOptional = encuestaService.findByName( nombre );
        if(encuestaOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.IM_USED);
        }
        // Si no, intentamos crearla
        boolean creada = encuestaService.crearEncuesta(idEncuesta, nombre, idEmpresa);
        if(creada){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    /**
     * Borra una encuesta basada en su id en la uri proyecto_ubb/encuestas/delete/{idEncuesta}
     * @param idEncuesta el id de la encuesta
     * @return 200 si se elimino, 409 si hubo un problema en la operacion, 404 si no se encontro
     */
    @DeleteMapping (value = "/delete/{idEncuesta}")
    public ResponseEntity< Void > deleteEncuesta(@PathVariable (value = "idEncuesta") int idEncuesta){
        Optional<Encuesta> encuestaOptional = encuestaService.findEncuestaById(idEncuesta);
        if(encuestaOptional.isPresent()){
            // Llamamos a que se eliminen sus preguntas aqui:
            
            if( encuestaService.deleteEncuesta(idEncuesta) ){
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        System.out.println("No se ha encontrado ninguna encuesta con el id: "+idEncuesta);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

        /**
     * Borra una encuesta basada en su id en la uri proyecto_ubb/encuestas/delete?nombre=
     * @param nombre el nombre de la encuesta
     * @return 200 si se elimino, 409 si hubo un problema en la operacion, 404 si no se encontro
     */
    @DeleteMapping (value = "/delete")
    public ResponseEntity< Void > deleteEncuesta(@RequestParam (value = "nombre") String nombre){
        Optional<Encuesta> encuestaOptional = encuestaService.findEncuestaByNombre(nombre);
        if(encuestaOptional.isPresent()){
            if( encuestaService.deleteEncuesta(nombre) ){
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        System.out.println("No se ha encontrado ninguna encuesta con el id: "+nombre);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

     /**
    Actualiza la visibilidad de una encuesta segun su ID
    @param idEncuesta El id de la encuesta
    */
    @PatchMapping (value = "/cambiarVisibilidad/{idEncuesta}")
    public ResponseEntity<Void> changeVisibilidad (@PathVariable (value = "idEncuesta") int idEncuesta)throws JsonMappingException{
        boolean actualizado = encuestaService.updateVisibilidad(idEncuesta);
          if(actualizado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
    

    /**
     * Cambia la descripcion de una encuesta a la URI: 
     * @param idEncuesta el id de la encuesta a  modificar
     * @param newDesc la descripcion de la nueva encuesta
     * @return 404 si no se encontro la encuesta, 200 si todo resulto ok
     */
    @PatchMapping(value = "cambiarDescripcion/{idEncuesta}")
    public ResponseEntity<Void> cambiarDescripcion (@PathVariable (value = "idEncuesta")int idEncuesta, @RequestBody String newDesc){
        
        boolean actualizado = encuestaService.updateDescripcion(idEncuesta,newDesc);
        if(actualizado){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    /**
     * Obtiene la descripcion de una encuesta
     * @param idEncuesta el id de la encuesta a recuperar la descripcion
     * @return la descripcion de la encuesta
     */
    @GetMapping (value = "/obtenerDescripcion/{idEncuesta}")
    public String getDescripcion (@PathVariable int idEncuesta){

        String descripcion = encuestaService.getDescripcion(idEncuesta);
        return descripcion;

    }
}
