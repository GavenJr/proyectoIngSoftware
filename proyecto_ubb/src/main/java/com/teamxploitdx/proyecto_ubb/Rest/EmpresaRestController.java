package com.teamxploitdx.proyecto_ubb.Rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamxploitdx.proyecto_ubb.Repository.EmpresaRepository;

@RestController     // definimos que es un controlador
@RequestMapping(value = "empresas", produces = "application/json")
public class EmpresaRestController {
    private final EmpresaRepository empresaRepository;

    public EmpresaRestController(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

}
