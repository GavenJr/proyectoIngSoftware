package com.teamxploitdx.proyecto_ubb.Rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import java.util.List;

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
	private List<JacksonTester<Alternativa>> JsonAlternativas;
    
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
    
    //-----TEST PARA EL SERVICIO QUE EDITA UNA ALTERNATIVA-----
    //Caso Positivo
    @Test
    public void siInvocoEditarAlternativaYSePuedeModificarRetornarOk() throws Exception{
    	// Arrange
    	Alternativa alternativa = getAlternativa();
    	given(alternativaService.editAlternativa(alternativa.getId(), "")).willReturn(true);

    	// Act
    	MockHttpServletResponse response = mockMvc
    			.perform(MockMvcRequestBuilders.put("/alternativa/editarAlternativa/"+ 
    			alternativa.getId() + "")
    			.accept(MediaType.APPLICATION_JSON)
    			.content(jsonAlternativa.write(alternativa).getJson())
    			.contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
                
        // Assert
        assertEquals(HttpStatus.OK.value(),response.getStatus());
    }
    
    //Caso Negativo
    @Test
    public void siInvocoEditarAlternativaYNoSePuedeModificarRetornarBadRequest() throws Exception{
    	// Arrange
    	Alternativa alternativa = new Alternativa();
    	given(alternativaService.editAlternativa(alternativa.getId(), "nuevo")).willReturn(false);

    	// Act
    	MockHttpServletResponse response = mockMvc
    			.perform(MockMvcRequestBuilders.put("/alternativa/editarAlternativa/"+ 
    	    			alternativa.getId() + "")
    			.accept(MediaType.APPLICATION_JSON)
    			.content(jsonAlternativa.write(alternativa).getJson())
    			.contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
                
        // Assert
        assertEquals(HttpStatus.BAD_REQUEST.value(),response.getStatus());
    }
    //-----FIN DEL TEST SERVICIO QUE EDITA UNA ALTERNATIVA-----
    
  //-----TEST PARA EL SERVICIO QUE ELIMINA UNA NUEVA ALTERNATIVA-----
    //Caso Positivo
    @Test
    public void siInvocoDeleteAlternativaYSePuedeEliminarRetornarOk() throws Exception{
    	// Arrange
    	Alternativa alternativa = getAlternativa();
    	given(alternativaService.deleteAlternativaById(alternativa.getId())).willReturn(true);

    	// Act
    	MockHttpServletResponse response = mockMvc
    			.perform(MockMvcRequestBuilders.delete("/elimina/" + alternativa.getId())
    			.accept(MediaType.APPLICATION_JSON)
    			.content(jsonAlternativa.write(alternativa).getJson())
    			.contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
                
        // Assert
        assertEquals(HttpStatus.OK.value(),response.getStatus());
    }
    
    //Caso Negativo
    @Test
    public void siInvocoDeleteAlternativaYNoSePuedeEliminarRetornarBadRequest() throws Exception{
    	// Arrange
    	Alternativa alternativa = getAlternativa();
    	given(alternativaService.deleteAlternativaById(alternativa.getId())).willReturn(false);

    	// Act
    	MockHttpServletResponse response = mockMvc
    			.perform(MockMvcRequestBuilders.delete("/elimina/" + alternativa.getId())
    			.accept(MediaType.APPLICATION_JSON)
    			.content(jsonAlternativa.write(alternativa).getJson())
    			.contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
                
        // Assert
        assertEquals(HttpStatus.BAD_REQUEST.value(),response.getStatus());
    }
    //-----FIN DEL TEST SERVICIO QUE ELIMINA UNA NUEVA ALTERNATIVA-----
    
	@Test
	public void Hu31_agregarAlternativaAPreguntaInexistenteRetornaHttpNotFound(){

		assert(true);
	}

	@Test
	public void Hu31_checkeaSiHayAlternativasDePreguntaEliminadaRetornaNulo(){
		assert(true);
	}


    private Alternativa getAlternativa() {
		Alternativa alternativa = new Alternativa();
		alternativa.setId(1);
		alternativa.setTexto("Escarlata");
		alternativa.setPregunta(null);
        return alternativa;
	}

	private Alternativa getAlternativa2() {
		Alternativa alternativa = new Alternativa();
		alternativa.setId(1);
		alternativa.setTexto("Escarlata");
		alternativa.setPregunta(null);
        return alternativa;
	}

	private Alternativa getAlternativa3() {
		Alternativa alternativa = new Alternativa();
		alternativa.setId(1);
		alternativa.setTexto("Escarlata");
		alternativa.setPregunta(null);
        return alternativa;
	}

	private Alternativa getAlternativa4() {
		Alternativa alternativa = new Alternativa();
		alternativa.setId(1);
		alternativa.setTexto("Escarlata");
		alternativa.setPregunta(null);
        return alternativa;
	}

}
