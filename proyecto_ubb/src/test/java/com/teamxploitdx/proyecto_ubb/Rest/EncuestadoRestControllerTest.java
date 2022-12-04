package com.teamxploitdx.proyecto_ubb.Rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamxploitdx.proyecto_ubb.Model.Categoria;
import com.teamxploitdx.proyecto_ubb.Model.Encuestado;
import com.teamxploitdx.proyecto_ubb.Service.EncuestadoService;


@ExtendWith(MockitoExtension.class)
public class EncuestadoRestControllerTest {
	  	@Mock
	    private EncuestadoService encuestadoService;
	    @InjectMocks
	    private EncuestadoRestController encuestadoRestController;

	    private MockMvc mockMvc;
	    private JacksonTester<Encuestado> jsonEncuestado;
	    
	    @BeforeEach
	    public void setup() {
	        JacksonTester.initFields(this,new ObjectMapper());
	        mockMvc = MockMvcBuilders.standaloneSetup(encuestadoRestController).build();
	    }
	    
	    
	    
	    //-----TEST PARA EL SERVICIO QUE AGREGA UNA CATEGORIA A LAS PREFERENCIAS DEL ENCUESTADO-----
	    //Caso Positivo
	    @Test
	    public void siInvocoUpdatePreferenciaYSePuedeAgregarRetornaOk() throws Exception{
	        // Arrange
	    	Categoria categoria = getAdd();
	        Encuestado encuestado = getEncuestado();
	        given(encuestadoService.addPreferencia(encuestado.getId(), categoria.getId())).willReturn(true);

	        // Act
	        MockHttpServletResponse response = mockMvc
	        		.perform(MockMvcRequestBuilders.post("/encuestado/"+encuestado.getId()+
	        		"/preferencia/agrega/"+categoria.getId())
	        				.accept(MediaType.APPLICATION_JSON)
	        				.content(jsonEncuestado.write(encuestado).getJson())
	        				.contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
	                
	        // Assert
	        assertEquals(HttpStatus.OK.value(),response.getStatus());
	    }
	    
	    //Caso Negativo
	    @Test
	    public void siInvocoUpdatePreferenciaYYaLaTieneRetornaBadRequest() throws Exception{
	        // Arrange
	    	Categoria categoria = getCategoria();
	        Encuestado encuestado = getEncuestado();
	        given(encuestadoService.addPreferencia(encuestado.getId(), categoria.getId())).willReturn(false);

	        // Act
	        MockHttpServletResponse response = mockMvc
	        		.perform(MockMvcRequestBuilders.post("/encuestado/"+encuestado.getId()+
	        		"/preferencia/agrega/"+categoria.getId())
	        				.accept(MediaType.APPLICATION_JSON)
	        				.content(jsonEncuestado.write(encuestado).getJson())
	        				.contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
	                
	        // Assert
	        assertEquals(HttpStatus.BAD_REQUEST.value(),response.getStatus());
	    }
	    //-----FIN DEL TEST SERVICIO QUE AGREGA UNA CATEGORIA A LAS PREFERENCIAS DEL ENCUESTADO-----
	    
	    //-----TEST PARA EL SERVICIO QUE ELIMINA UNA CATEGORIA A LAS PREFERENCIAS DEL ENCUESTADO-----
	    //Caso Positivo
	    @Test
	    public void siInvocoDeletePreferenciaYSePuedeEliminarRetornaOk() throws Exception{
	        // Arrange
	    	Categoria categoria = getCategoria();
	        Encuestado encuestado = getEncuestado();
	        given(encuestadoService.deletePreferenciaById(categoria.getId(),encuestado.getId())).willReturn(true);

	        // Act
	        MockHttpServletResponse response = mockMvc
	        		.perform(MockMvcRequestBuilders.delete("/encuestado/"+encuestado.getId()+
	        		"/preferencia/elimina/"+categoria.getId())
	        				.accept(MediaType.APPLICATION_JSON)
	        				.content(jsonEncuestado.write(encuestado).getJson())
	        				.contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
	                
	        // Assert
	        assertEquals(HttpStatus.OK.value(),response.getStatus());
	    }
	    
	    //Caso Negativo
	    @Test
	    public void siInvocoDeletePreferenciaYNoLaTieneRetornaBadRequest() throws Exception{
	        // Arrange
	    	Categoria categoria = getAdd();
	        Encuestado encuestado = getEncuestado();
	        given(encuestadoService.deletePreferenciaById(categoria.getId(), encuestado.getId())).willReturn(false);
	        
	        // Act
	        MockHttpServletResponse response = mockMvc
	        		.perform(MockMvcRequestBuilders.delete("/encuestado/"+encuestado.getId()+
	        		"/preferencia/elimina/"+categoria.getId())
	        				.accept(MediaType.APPLICATION_JSON)
	        				.content(jsonEncuestado.write(encuestado).getJson())
	        				.contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
	                
	        // Assert
	        assertEquals(HttpStatus.BAD_REQUEST.value(),response.getStatus());
	    }
	    //-----FIN DEL TEST SERVICIO QUE ELIMINA UNA CATEGORIA A LAS PREFERENCIAS DEL ENCUESTADO-----
	  
	    //-----TEST PARA EL SERVICIO QUE AGREGA UN NUEVO ENCUESTADO-----
	    //Caso Positivo
	    @Test
	    public void siInvocoAddEncuestadoYSePuedeAgregarRetornarSatusCreated() throws Exception{
	    	// Arrange
	    	Encuestado encuestado = getEncuestado();
	    	given(encuestadoService.save(any(Encuestado.class))).willReturn(true);

	    	// Act
	    	MockHttpServletResponse response = mockMvc
	    			.perform(MockMvcRequestBuilders.post("/encuestado/")
	    			.accept(MediaType.APPLICATION_JSON)
	    			.content(jsonEncuestado.write(encuestado).getJson())
	    			.contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
	                
	        // Assert
	        assertEquals(HttpStatus.CREATED.value(),response.getStatus());
	    }  
	    
	    //Caso Negativo
	    @Test
	    public void siInvocoAddEncuestadoYNoSePuedeAgregarRetornarBadRequest() throws Exception{
	    	// Arrange
	    	Encuestado encuestado = getEncuestado();
	    	given(encuestadoService.save(any(Encuestado.class))).willReturn(false);

	    	// Act
	    	MockHttpServletResponse response = mockMvc
	    			.perform(MockMvcRequestBuilders.post("/encuestado/")
	    			.accept(MediaType.APPLICATION_JSON)
	    			.content(jsonEncuestado.write(encuestado).getJson())
	    			.contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
	                
	        // Assert
	        assertEquals(HttpStatus.BAD_REQUEST.value(),response.getStatus());
	    }
	    //-----FIN DEL TEST SERVICIO QUE AGREGA UN NUEVO ENCUESTADO-----
	  
	    
	  
	    //Metodos para crear datos de prueba
		private Encuestado getEncuestado() {
			Encuestado encuestado = new Encuestado();
	        encuestado.setId(1);
	        encuestado.setNombre("Juan");
	        encuestado.setApellido("Mendez");
	        encuestado.setEmail("juan.mendez@supermail.com");
	        encuestado.addPreferencias(getCategoria());
	        return encuestado;
		}


		private Categoria getCategoria() {
			Categoria categoria = new Categoria();
			categoria.setId(1);
			categoria.setNombre("Deporte");
			return categoria;
		}
		
		private Categoria getAdd() {
			Categoria categoria = new Categoria();
			categoria.setId(2);
			categoria.setNombre("Hogar");
			return categoria;
		}
}
