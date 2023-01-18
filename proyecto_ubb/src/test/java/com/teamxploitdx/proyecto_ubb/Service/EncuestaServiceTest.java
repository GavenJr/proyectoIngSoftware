package com.teamxploitdx.proyecto_ubb.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.teamxploitdx.proyecto_ubb.Model.Encuesta;
import com.teamxploitdx.proyecto_ubb.Repository.EncuestaRepository;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Optional;

@ExtendWith (MockitoExtension.class)
public class EncuestaServiceTest {
    
    @Mock
    private EncuestaRepository encuestaRepo;


    @InjectMocks
    private EncuestaService encuestaService;



    @Test
    public void siInvocoFindALlEncuestasEntoncesRetornaTodasLasEncuestas(){

        //Arrange
        List <Encuesta> encuestas = new ArrayList<>();
        Encuesta encuesta = new Encuesta();
        encuestas.add(encuesta);

        when(encuestaRepo.findAll()).thenReturn(encuestas);

        //Act
        List <Encuesta> resultado = encuestaService.findAllEncuestas();
        
        //Assert
        assertEquals(resultado, encuestas);

    }
    @Test
    public void siInvocoFindALlEncuestasEntoncesRetornaLaListaVacia(){

        //Arrange
        when(encuestaRepo.findAll()).thenReturn(new ArrayList<>());

        //Act
        List <Encuesta> resultado = encuestaService.findAllEncuestas();
        
        //Assert
        assertTrue(resultado.isEmpty());

    }
    
    //Cambia la visibilidad entonces retorna TRUE
    @Test
    public void siInvocoUpdateVisibilidadEntoncesRetornaTrue(){

        //Arrange
        Encuesta encuesta = new Encuesta();

        Optional<Encuesta> encuestaOptional = Optional.of(encuesta);
        
        when (encuestaRepo.findById(2)).thenReturn(encuestaOptional);
        
        // Act
        boolean resultado = encuestaService.updateVisibilidad(2);

        // Assert
        assertTrue(resultado);
        assertEquals(encuesta.isVisible(), true);

    }
    @Test
    public void siInvocoUpdateDescripcionEntoncesRetornaTrue(){

        //Arrange
        Encuesta encuesta = new Encuesta();

        Optional<Encuesta> encuestaOptional = Optional.of(encuesta);
        
        when (encuestaRepo.findById(2)).thenReturn(encuestaOptional);
        
        // Act
        boolean resultado = encuestaService.updateDescripcion(2, "null");

        // Assert
        assertTrue(resultado);
        assertEquals(encuesta.getDescripcion(), "null");

    }
   
    @Test
    public void siInvocoGetDescripcionYExisteEncuestaEntoncesRetornaTrue(){

        //Arrange
        Encuesta encuesta = getEncuesta();

        Optional<Encuesta> encuestaOptional = Optional.of(encuesta);
        
        when (encuestaRepo.findById(1)).thenReturn(encuestaOptional);
        
        // Act
        String resultado = encuestaService.getDescripcion(encuesta.getId());

        // Assert
        assertEquals(resultado, encuesta.getDescripcion());

    }

    @Test
    public void updateMaxRespuestasTestCaseGood(){
        int id= 12;
        int newMax=15;
        Encuesta encuesta= encuestaRepo.getReferenceById(12);
        //Optional<Encuesta> encuestaOptional=encuestaRepository.findById(12);
        when(encuestaRepo.getById(12))
                .thenReturn(encuesta);
        // Act
        encuesta.setMax_respuestas(15);
        boolean resultado = encuestaService.crearEncuesta(encuesta);

        // Assert
        assertTrue(resultado);
    }

    @Test
    public void updateMaxRespuestasTestCaseBad(){
        int id= 14;
        int newMax=15;
        when(encuestaRepo.getById(12)).thenReturn(null);
        //Act
        boolean result= encuestaService.updateMaxRespuestas(12,15);
        //Assert
        assertFalse(result);
    }






    private Encuesta getEncuesta(){
        Encuesta encuesta = new Encuesta();
        encuesta.setId(1);
        encuesta.setVisible(false);
        encuesta.setDescripcion("null");
        return encuesta;
    }
}
