package com.teamxploitdx.proyecto_ubb.Service;

import com.teamxploitdx.proyecto_ubb.Model.Categoria;
import com.teamxploitdx.proyecto_ubb.Model.Encuestado;
import com.teamxploitdx.proyecto_ubb.Repository.CategoriaRepository;
import com.teamxploitdx.proyecto_ubb.Repository.EncuestadoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoriaServiceTest {
    @Mock
    private CategoriaRepository categoriaRepository;
    @Mock
    private EncuestadoRepository encuestadoRepository;
    @InjectMocks
    private CategoriaService categoriaService;

    @Test
    public void saveCategoriaTestGood(){
        // Arrange
        Categoria categoria = new Categoria();
        categoria.setId(12);
        categoria.setNombre("cat1");
        Optional<Categoria> categoriaOptional = Optional.of(categoria);
        when(categoriaRepository.findCategoriaById(12)).thenReturn(categoriaOptional);
        // Act
        boolean resultado = categoriaService.saveCategoria(categoria);

        // Assert
        assertTrue(resultado);
    }
    @Test
    public void saveCategoriaTestBad(){
        //Arrange
        Categoria categoria= null;
        Optional<Categoria> categoriaOptional = Optional.of(categoria);
        when(categoriaRepository.findCategoriaById(any())).thenReturn(null);
        //Act
        boolean result= categoriaService.saveCategoria(categoria);
        //Assert
        assertFalse(result);
    }

}