package com.teamxploitdx.proyecto_ubb.Rest;
// imports de Java
import java.util.List;
// imports de spring boot
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// imports locales
import com.teamxploitdx.proyecto_ubb.Model.Encuesta;
import com.teamxploitdx.proyecto_ubb.Service.EncuestaService;

@RestController
@RequestMapping(value = "encuestas", produces = "application/json")
public class EncuestaRestController {                           // Usamos la notacion json para obtener resultados
    EncuestaService encuestaService;

    public EncuestaRestController(EncuestaService encuestaService) {
        this.encuestaService = encuestaService;
    }

    // Operacion GET, vacia pues la URI termina en "encuestas"
    @GetMapping(value = "")
    public ResponseEntity< List<Encuesta> > getEncuestas(){
        List<Encuesta> encuestaList = encuestaService.findAllEncuestas();
        if( !encuestaList.isEmpty() ){
            return new ResponseEntity<>(encuestaList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(encuestaList, HttpStatus.NOT_FOUND);
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
