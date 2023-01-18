package com.teamxploitdx.proyecto_ubb.Rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamxploitdx.proyecto_ubb.Model.Categoria;
import com.teamxploitdx.proyecto_ubb.Model.Encuestado;
import com.teamxploitdx.proyecto_ubb.Service.CategoriaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
@ExtendWith(MockitoExtension.class)
public class CategoriaRestControllerTest {
    @InjectMocks
    CategoriaRestController categoriaRestController;
    @Mock
    CategoriaService categoriaService;

    private MockMvc mockMvc;
    private JacksonTester<Categoria> jsonCategoria;

    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this,new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(categoriaRestController).build();
    }


    @Test
    public void addCategoriaTestGood () throws Exception{

        // Arrange
        Categoria categoria = new Categoria();//null
        given(categoriaService.saveCategoria(categoria)).willReturn(true);

        // Act
        MockHttpServletResponse response = mockMvc
                .perform(MockMvcRequestBuilders.post("/categoria/")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonCategoria.write(categoria).getJson())
                        .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        // Assert
        assertEquals(HttpStatus.CREATED.value(),response.getStatus());
    }
    @Test
    public void addCategoriaTestBad() throws Exception{
        // Arrange
        Categoria categoria= null;
        given(categoriaService.saveCategoria(any(Categoria.class))).willReturn(false);

        // Act
        MockHttpServletResponse response = mockMvc
                .perform(MockMvcRequestBuilders.post("/encuestado/")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(jsonCategoria.write(categoria).getJson())
                        .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST.value(),response.getStatus());
    }

}