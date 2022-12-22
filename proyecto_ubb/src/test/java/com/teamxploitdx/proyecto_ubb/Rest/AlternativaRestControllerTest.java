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
import com.teamxploitdx.proyecto_ubb.Model.Alternativa;
import com.teamxploitdx.proyecto_ubb.Service.AlternativaService;

@ExtendWith(MockitoExtension.class)
public class AlternativaRestControllerTest {
	@Mock
    private AlternativaService alternativaService;
    @InjectMocks
    private AlternativaRestController alternativaRestController;

    private MockMvc mockMvc;
    private JacksonTester<Alternativa> jsonAlternativa;
    
    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this,new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(alternativaRestController).build();
    }
    
  //-----TEST PARA EL SERVICIO QUE AGREGA UNA NUEVA ALTERNATIVA-----
    //Caso Positivo
    @Test
    public void siInvocoAddAlternativaYSePuedeAgregarRetornarSatusCreated() throws Exception{
    	// Arrange
    	Alternativa alternativa = getAlternativa();
    	given(alternativaService.save(any(Alternativa.class))).willReturn(true);

    	// Act
    	MockHttpServletResponse response = mockMvc
    			.perform(MockMvcRequestBuilders.post("/alternativa/")
    			.accept(MediaType.APPLICATION_JSON)
    			.content(jsonAlternativa.write(alternativa).getJson())
    			.contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
                
        // Assert
        assertEquals(HttpStatus.CREATED.value(),response.getStatus());
    }  

	//Caso Negativo
    @Test
    public void siInvocoAddAlternativaYNoSePuedeAgregarRetornarBadRequest() throws Exception{
    	// Arrange
    	Alternativa alternativa = getAlternativa();
    	given(alternativaService.save(any(Alternativa.class))).willReturn(false);

    	// Act
    	MockHttpServletResponse response = mockMvc
    			.perform(MockMvcRequestBuilders.post("/alternativa/")
    			.accept(MediaType.APPLICATION_JSON)
    			.content(jsonAlternativa.write(alternativa).getJson())
    			.contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
                
        // Assert
        assertEquals(HttpStatus.BAD_REQUEST.value(),response.getStatus());
    }
    //-----FIN DEL TEST SERVICIO QUE AGREGA UNA NUEVA ALTERNATIVA-----
    
    private Alternativa getAlternativa() {
		Alternativa alternativa = new Alternativa();
		alternativa.setId(1);
		alternativa.setTexto("Escarlata");
		alternativa.setPregunta(null);
        return alternativa;
	}
}
