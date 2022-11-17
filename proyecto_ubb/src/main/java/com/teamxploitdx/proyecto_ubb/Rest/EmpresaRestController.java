package com.teamxploitdx.proyecto_ubb.Rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamxploitdx.proyecto_ubb.Model.Empresa;
import com.teamxploitdx.proyecto_ubb.Service.EmpresaService;

@RestController     // definimos que es un controlador
@RequestMapping(value = "empresas", produces = "application/json")
public class EmpresaRestController {
    private final EmpresaService empresaService;

    public EmpresaRestController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    /**
    Retorna todas las empresas a la URI "/proyecto_ubb/empresas"
    */    
    @GetMapping(value = "")
    public ResponseEntity< List<Empresa> > getAllEmpresas(){
        // Busca las empresas
        List<Empresa> encuestaList = empresaService.findAllEmpresas();
        // Comprueba si se encontro alguna
        if( !encuestaList.isEmpty() ){
            return new ResponseEntity<>(encuestaList, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
