package com.teamxploitdx.proyecto_ubb.Service;

import org.springframework.stereotype.Service;

import com.teamxploitdx.proyecto_ubb.Repository.BorradorRepository;
import com.teamxploitdx.proyecto_ubb.Repository.RespuestaRepository;

@Service
public class RespuestaService {
    private final RespuestaRepository respuestaRepository;
    private final BorradorRepository borradorRepository;


    public RespuestaService(RespuestaRepository respuestaRepository, BorradorRepository borradorRepository) {
        this.respuestaRepository = respuestaRepository;
        this.borradorRepository = borradorRepository;
    }

}
