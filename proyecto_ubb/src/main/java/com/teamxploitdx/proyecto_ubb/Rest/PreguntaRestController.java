package com.teamxploitdx.proyecto_ubb.Rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.teamxploitdx.proyecto_ubb.Model.Encuesta;
import com.teamxploitdx.proyecto_ubb.Model.Pregunta;
import com.teamxploitdx.proyecto_ubb.Service.EncuestaService;
import com.teamxploitdx.proyecto_ubb.Service.PreguntaService;

@RestController
@RequestMapping (value = "pregunta", produces = "application/json")
public class PreguntaRestController {
    
    @Autowired
    PreguntaService preguntaService;

    public PreguntaRestController (PreguntaService preguntaService){
        this.preguntaService = preguntaService;
    }
    @GetMapping (value = "")
    public ResponseEntity <List<Pregunta>> getAllPreguntas(){
        List<Pregunta> preguntaList = preguntaService.findAllPreguntas();
        if(!preguntaList.isEmpty()){
            return new ResponseEntity<>(preguntaList,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping (value ="/addPregunta")

    public ResponseEntity <Void> crearPregunta (@RequestBody Pregunta pregunta)throws JsonMappingException{

        boolean anadido = preguntaService.AddPregunta(pregunta);
        if (anadido){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @DeleteMapping (value = "/delete/{idPregunta}")
    public ResponseEntity<Void> deletePregunta (@PathVariable (value = "idPregunta") int idPregunta){
        boolean delete = preguntaService.deletePregunta(idPregunta);
        if(delete){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PatchMapping (value = "/editPregunta/{idPregunta}")
    public ResponseEntity<Void> editarPregunta (@RequestBody String texto,@PathVariable (value = "idPregunta") int idPregunta)throws JsonMappingException{
        boolean edit = preguntaService.editPregunta(texto,idPregunta);
        if(edit){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
