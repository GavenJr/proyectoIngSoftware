package com.teamxploitdx.proyecto_ubb.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jayway.jsonpath.Option;
import com.teamxploitdx.proyecto_ubb.Model.Encuesta;
import com.teamxploitdx.proyecto_ubb.Model.Pregunta;
import com.teamxploitdx.proyecto_ubb.Repository.EncuestaRepository;
import com.teamxploitdx.proyecto_ubb.Repository.PreguntaRepository;

@ExtendWith (MockitoExtension.class)
public class PreguntaServiceTest {
    
       
    @Mock
    private PreguntaRepository pregRepo;
    @Mock
    private EncuestaRepository encRepo;


    @InjectMocks
    private PreguntaService pregService;

    // Test para el metodo FindAllPreguntas
    // Caso Positivo
    @Test
    public void siInvocoFindALlPreguntasEntoncesRetornaTodasLasEncuestas(){

        //Arrange
        List <Pregunta> preguntas = new ArrayList<>();
        Pregunta pregunta = new Pregunta();
        preguntas.add(pregunta);

        when(pregRepo.findAll()).thenReturn(preguntas);

        //Act
        List <Pregunta> resultado = pregService.findAllPreguntas();
        
        //Assert
        assertEquals(resultado, preguntas);
    
    }

    //Caso Negativo
    @Test
    public void siInvocoFindALlPreguntasEntoncesRetornaLaListaVacia(){

        //Arrange
        when(pregRepo.findAll()).thenReturn(new ArrayList<>());

        //Act
        List <Pregunta> resultado = pregService.findAllPreguntas();
        
        //Assert
        assertTrue(resultado.isEmpty());

    }

    //Test para el servicio FindById
   // Caso Positivo
    @Test
    public void siInvocoFindPreguntaByIdEntoncesRetornaLaPregunta(){

        //Arrange
    
        Pregunta pregunta = getPregunta();
        Optional <Pregunta> opPregunta = Optional.of(pregunta);

        when(pregRepo.findById(1)).thenReturn(opPregunta);

        //Act
        Optional <Pregunta> resultado = pregService.findPreguntaById(1);
        
        //Assert
        assertEquals(resultado.get(), opPregunta.get());
    }

    // Test para el Servicio AddPregunta
    @Test
    public void SiInvocoAddPreguntaEntoncesRetornaTrue(){
        //Arrange
        Pregunta pregunta = getPregunta();
        Encuesta encuesta = getEncuesta();

        Optional <Pregunta> opPregunta = Optional.of(pregunta);
        Optional <Encuesta> opEncuesta = Optional.of(encuesta);

        when (encRepo.findById(encuesta.getId())).thenReturn(opEncuesta);
        when (pregRepo.findById(pregunta.getId())).thenReturn(opPregunta);
        
        //Act
        boolean resultado = pregService.AddPregunta(pregunta);

        //Assert
        assertTrue(resultado);
        verify(pregRepo).saveAndFlush(pregunta);
    }
    @Test 
    public void SiInvocoEditPreguntaEntoncesRetornaTrue(){
        //Arrange
        Pregunta pregunta = getPregunta();
        String texto = "nuevoTexto";
        Optional <Pregunta > opPregunta = Optional.of(pregunta);

        when (pregRepo.findById(pregunta.getId())).thenReturn(opPregunta);

        boolean resultado = pregService.editPregunta(texto, 1);

        assertEquals(texto, opPregunta.get().getTexto());

    }
    // @Test
    // public void SiInvocoAddPreguntaEntoncesRetornaSalse(){
    //     //Arrange
    //     Pregunta pregunta = getPregunta();
    //     Encuesta encuesta = getEncuesta();

    //     Optional <Pregunta> opPregunta = Optional.of(pregunta);
    //     Optional <Encuesta> opEncuesta = Optional.of(encuesta);

    //     when (encRepo.findById(encuesta.getId())).thenReturn(null);
    //     when (pregRepo.findById(pregunta.getId())).thenReturn(opPregunta);
        
    //     //Act
    //     boolean resultado = pregService.AddPregunta(pregunta, 1);

    //     //Assert
    //     assertFalse(resultado);

    // }
        
        //Test para servicio de deletePregunta
        @Test
        public void SiInvocoDeletePreguntaEntoncesRetornaTrue(){
            Optional <Pregunta> preg = Optional.of(getPregunta());
            when (pregRepo.findById(preg.get().getId())).thenReturn(preg);

            boolean resultado = pregService.deletePregunta(preg.get().getId());

            assertTrue(resultado);
        }






    private Pregunta getPregunta(){
        Pregunta pregunta = new Pregunta();
        pregunta.setId(1);
        pregunta.setObligatoria(false);
        pregunta.setOrden(4);
        pregunta.setTexto("null");
        pregunta.setEncuesta(getEncuesta());
        return pregunta;
    }
    private Encuesta getEncuesta(){
        Encuesta encuesta = new Encuesta();
        encuesta.setId(1);
        encuesta.setVisible(false);
        encuesta.setDescripcion("null");
        return encuesta;
    }
}
