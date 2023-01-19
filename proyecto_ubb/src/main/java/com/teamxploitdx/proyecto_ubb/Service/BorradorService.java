package com.teamxploitdx.proyecto_ubb.Service;

import org.springframework.stereotype.Service;

import com.teamxploitdx.proyecto_ubb.Repository.BorradorRepository;
import com.teamxploitdx.proyecto_ubb.Repository.EncuestaRepository;

@Service
public class BorradorService {
    private final BorradorRepository borradorRepository;
    private final EncuestaRepository encuestaRepository;



    public BorradorService(BorradorRepository borradorRepository, EncuestaRepository encuestaRepository) {
        this.borradorRepository = borradorRepository;
        this.encuestaRepository = encuestaRepository;
    }
    
}
