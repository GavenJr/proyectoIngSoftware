package com.teamxploitdx.proyecto_ubb.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.teamxploitdx.proyecto_ubb.Model.Categoria;
import com.teamxploitdx.proyecto_ubb.Model.Encuestado;
import com.teamxploitdx.proyecto_ubb.Repository.CategoriaRepository;
import com.teamxploitdx.proyecto_ubb.Repository.EncuestadoRepository;


@ExtendWith(MockitoExtension.class)
public class EncuestadoServiceTest {
	@Mock
	private EncuestadoRepository encuestadoRepository;
	@Mock
	private  CategoriaRepository categoriaRepository;
	
	@InjectMocks
	private EncuestadoService encuestadoService;
	
	//-----TEST PARA EL METODO ADDPREFERENCIA-----
    //Caso Positivo
	@Test
    public void siInvocoAddPreferenciaYNoExisteCategoriaEnPreferenciasRetornarTrue(){
		// Arrange
		Encuestado encuestado = getEncuestado();
		Categoria categoria = getAdd();
		Optional<Encuestado> encuestadoOptional = Optional.of(encuestado);
		Optional<Categoria> categoriaOptional = Optional.of(categoria);
		when(encuestadoRepository.findById(encuestado.getId()))
			.thenReturn(encuestadoOptional);
		when(categoriaRepository.findById(categoria.getId()))
			.thenReturn(categoriaOptional);
		
		// Act
		boolean resultado = encuestadoService.addPreferencia(encuestado.getId(), 
				categoria.getId());
		
		// Assert
		assertTrue(resultado);
        verify(encuestadoRepository).saveAndFlush(encuestado);
	}
	
	//Caso Negativo
	@Test
    public void siInvocoAddPreferenciaYNoExisteEncuestadoRetornarFalse(){
		// Arrange
		Encuestado encuestado = new Encuestado();
		Categoria categoria = getCategoria().get(0);
		
		// Act
		boolean resultado = encuestadoService.addPreferencia(encuestado.getId(), 
				categoria.getId());
		
		// Assert
		assertFalse(resultado);
	}
	//-----FIN DEL TEST METODO ADDPREFERENCIA-----
	
	//-----TEST PARA EL METODO SAVE-----
    //Caso Positivo
	@Test
    public void siInvocoSaveYNoExisteEncuestadoConElNombreRetornarTrue(){
        // Arrange
        Encuestado encuestado = getEncuestado();
        Optional<Encuestado> encuestadoOptional = Optional.of(encuestado);
        Optional<Encuestado> encuestadoOptionalVacio = Optional.empty();
        when(encuestadoRepository.findEncuestadoByNombre(encuestado.getNombre()))
        		.thenReturn(encuestadoOptionalVacio)
        		.thenReturn(encuestadoOptional);
        // Act
        boolean resultado = encuestadoService.save(encuestado);

        // Assert
        assertTrue(resultado);
        verify(encuestadoRepository).saveAndFlush(encuestado);
    }
	
	//Caso Negativo
	@Test
    public void siInvocoSaveYExisteEncuestadoConElNombreRetornarFalse(){
        // Arrange
        Encuestado encuestado = getEncuestado();
        Optional<Encuestado> encuestadoOptional = Optional.of(encuestado);
        when(encuestadoRepository.findEncuestadoByNombre(encuestado.getNombre()))
                .thenReturn(encuestadoOptional);
        // Act
        boolean resultado = encuestadoService.save(encuestado);

        // Assert
        assertFalse(resultado);
    }
	//-----FIN DEL TEST METODO SAVE-----
	
	//-----TEST PARA EL METODO DELETEPREFERENCIA-----
    //Caso Positivo
	@Test
    public void siInvocoDeletePreferenciaByIdYExisteEncuestadoConCategoriaRetornarTrue(){
        // Arrange
        Encuestado encuestado = getEncuestado();
        Optional<Encuestado> encuestadoOptional = Optional.of(encuestado);
        Categoria categoria = getCategoria().get(0);
        Optional<Categoria> categoriaOptional = Optional.of(categoria);
	
        when(categoriaRepository.findById(categoria.getId())).thenReturn(categoriaOptional);
        when(encuestadoRepository.findById(encuestado.getId())).thenReturn(encuestadoOptional);
        
        // Act
        boolean resultado = encuestadoService.deletePreferenciaById(categoria.getId(),
        					encuestado.getId());

        // Assert
        assertTrue(!resultado);
        verify(encuestadoRepository).saveAndFlush(encuestado);
    }
	
	//Caso Negativo
	@Test
    public void siInvocoDeletePreferenciaByIdYNoExisteEncuestadoRetornarFalse(){
		// Arrange
		Encuestado encuestado = getEncuestado();
		Optional<Encuestado> encuestadoOptional = Optional.of(encuestado);
		Categoria categoria = getAdd();
		Optional<Categoria> categoriaOptional = Optional.of(categoria);
		when(categoriaRepository.findById(categoria.getId())).thenReturn(categoriaOptional);
		when(encuestadoRepository.findById(encuestado.getId())).thenReturn(encuestadoOptional);

		// Act
		boolean resultado = encuestadoService.deletePreferenciaById(categoria.getId(), 
				encuestado.getId());
		
		// Assert
		assertFalse(resultado);
	}
	//-----FIN DEL TEST METODO DELETEPREFERENCIA-----
	
	//-----TEST PARA EL METODO FINDENCUESTADOBYID-----
    //Caso Positivo
	@Test
    public void siInvocoGetEncuestadoByIdYExisteEncuestadoRetornarEncuestado() {
        // Arrange
        Encuestado encuestado = getEncuestado();
        Optional<Encuestado> encuestadoOptional = Optional.of(encuestado);
        when(encuestadoRepository.findById(encuestado.getId())).thenReturn(encuestadoOptional);
        
        // Act
        Encuestado resultado = encuestadoService.findEncuestadoById(encuestado.getId()).get();


        // Assert
        assertNotNull(resultado);
        assertEquals(encuestado, resultado);
    }
	
	//Caso Negativo
	@Test
    public void siInvocoGetEncuestadoByIdYNoExisteEncuestadoRetornarVacio() {
		// Arrange
		Encuestado encuestado = getEncuestado();
		Optional<Encuestado> encuestadoOptional = Optional.of(new Encuestado());
        when(encuestadoRepository.findById(encuestado.getId())).thenReturn(encuestadoOptional);
        
        // Act
        Encuestado resultado = encuestadoService.findEncuestadoById(encuestado.getId()).get();

        // Assert
        assertNotNull(resultado);
        assertEquals(encuestadoOptional.get(),resultado);
	}
	//-----FIN DEL TEST METODO FINDENCUESTADOBYID-----
	
	
	//Metodos para crear datos de prueba
	private Encuestado getEncuestado() {
		Encuestado encuestado = new Encuestado();
        encuestado.setId(1);
        encuestado.setNombre("Juan");
        encuestado.setApellido("Mendez");
        encuestado.setEmail("juan.mendez@supermail.com");
        encuestado.addPreferencias(getCategoria().get(0));
        return encuestado;
	}

	private List<Categoria> getCategoria() {
	        List<Categoria> categorias = new ArrayList<>();
	        Categoria categoria = new Categoria();
	        categoria.setId(1);
	        categoria.setNombre("Deporte");
	        categorias.add(categoria);
	        categoria = new Categoria();
	        categoria.setId(2);
	        categoria.setNombre("Hogar");
	        categorias.add(categoria);
	        return categorias;
	}
	
	private Categoria getAdd() {
		Categoria categoria = new Categoria();
		categoria.setId(2);
		categoria.setNombre("Hogar");
		return categoria;
	}
}
