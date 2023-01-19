package com.teamxploitdx.proyecto_ubb.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.teamxploitdx.proyecto_ubb.Model.Respuesta;
import java.util.List;
import java.util.Optional;

@Repository
public interface RespuestaRepository extends JpaRepository <Respuesta, Integer>{

     Optional<Respuesta> findRespuestaByPreguntaId(Integer id);
    
}






