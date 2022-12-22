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
	
	private Alternativa getAlternativa() {
		Alternativa alternativa = new Alternativa();
		alternativa.setId(1);
		alternativa.setTexto("Escarlata");
		alternativa.setPregunta(null);
        return alternativa;
	}
}
