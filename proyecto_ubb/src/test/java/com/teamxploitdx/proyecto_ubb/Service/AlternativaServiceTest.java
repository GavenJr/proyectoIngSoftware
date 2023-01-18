package com.teamxploitdx.proyecto_ubb.Service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.teamxploitdx.proyecto_ubb.Model.Alternativa;
import com.teamxploitdx.proyecto_ubb.Repository.AlternativaRepository;

@ExtendWith(MockitoExtension.class)
public class AlternativaServiceTest {
	@Mock
	private AlternativaRepository alternativaRepository;
	
	@InjectMocks
	private AlternativaService alternativaService;
	
	//-----TEST PARA EL METODO SAVE-----
    //Caso Positivo
	@Test
    public void siInvocoSaveYNoExisteAlternativaConElIdRetornarTrue(){
        // Arrange
        Alternativa alternativa = getAlternativa();
        Optional<Alternativa> altOptional = Optional.of(alternativa);
        Optional<Alternativa> altOptionalVacio = Optional.empty();
        when(alternativaRepository.findAlternativaById(alternativa.getId()))
        		.thenReturn(altOptionalVacio )
        		.thenReturn(altOptional);
        // Act
        boolean resultado = alternativaService.save(alternativa);

        // Assert
        assertTrue(resultado);
        verify(alternativaRepository).saveAndFlush(alternativa);
    }

	//Caso Negativo
	@Test
    public void siInvocoSaveYExisteAlternativaConElIdRetornarFalse(){
        // Arrange
		Alternativa alternativa = getAlternativa();
        Optional<Alternativa> altOptional = Optional.of(alternativa);
        when(alternativaRepository.findAlternativaById(alternativa.getId()))
				.thenReturn(altOptional);
        // Act
        boolean resultado = alternativaService.save(alternativa);

        // Assert
        assertFalse(resultado);
    }
	//-----FIN DEL TEST METODO SAVE-----
	
	//-----TEST PARA EL METODO EDITALTERNATIVA-----
    //Caso Positivo
	@Test
    public void siInvocoEditAlternativaYExisteAlternativaConElIdRetornarTrue(){
        // Arrange
        Alternativa alternativa = getAlternativa();
        Optional<Alternativa> altOptional = Optional.of(alternativa);
        when(alternativaRepository.findById(alternativa.getId()))
        		.thenReturn(altOptional);
        // Act
        boolean resultado = alternativaService.editAlternativa(alternativa.getId(), "");

        // Assert
        assertTrue(resultado);
        verify(alternativaRepository).saveAndFlush(alternativa);
    }

	//Caso Negativo
	@Test
    public void siInvocoEditAlternativaYNoExisteAlternativaConElIdRetornarTrue(){
        // Arrange
		Alternativa alternativa = getAlternativa();
        Optional<Alternativa> altOptional = Optional.of(alternativa);
        when(alternativaRepository.findById(alternativa.getId()))
				.thenReturn(altOptional);
        // Act
        boolean resultado = !alternativaService.editAlternativa( alternativa.getId(), "");

        // Assert
        assertFalse(resultado);
    }
	//-----FIN DEL TEST METODO EDITALTERNATIVA-----
	
	//-----TEST PARA EL METODO DELETEALTERNATIVABYID-----
    //Caso Positivo
	@Test
    public void siInvocoDeleteAlternativaByIdYExisteAlternativaConElIdRetornarTrue(){
        // Arrange
        Alternativa alternativa = getAlternativa();
        Optional<Alternativa> altOptional = Optional.of(alternativa);
        when(alternativaRepository.findById(alternativa.getId()))
        		.thenReturn(altOptional);
        // Act
        boolean resultado = alternativaService.deleteAlternativaById(alternativa.getId());

        // Assert
        assertTrue(resultado);
        verify(alternativaRepository).delete(alternativa);
    }

	//Caso Negativo
	@Test
    public void siInvocoDeleteAlternativaByIdYNoExisteAlternativaConElIdRetornarFalse(){
        // Arrange
		Alternativa alternativa = getAlternativa();
        Optional<Alternativa> altOptional = Optional.of(alternativa);
        when(alternativaRepository.findById(alternativa.getId()))
				.thenReturn(altOptional);
        // Act
        boolean resultado = !alternativaService.deleteAlternativaById( alternativa.getId());

        // Assert
        assertFalse(resultado);
    }
	//-----FIN DEL TEST METODO DELETEALTERNATIVABYID-----
	
	
	private Alternativa getAlternativa() {
		Alternativa alternativa = new Alternativa();
		alternativa.setId(1);
		alternativa.setTexto("Escarlata");
		alternativa.setPregunta(null);
        return alternativa;
	}
}
