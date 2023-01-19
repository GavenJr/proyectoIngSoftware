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
import com.teamxploitdx.proyecto_ubb.Model.Encuesta;
import com.teamxploitdx.proyecto_ubb.Model.Pregunta;
import com.teamxploitdx.proyecto_ubb.Service.PreguntaService;

@ExtendWith(MockitoExtension.class)
public class PregunaRestControllerTest {
    
    @Mock
    private PreguntaService preguntaService;
    @InjectMocks
    private PreguntaRestController preguntaRestController;

    private MockMvc mockMvc;
    private JacksonTester<Pregunta> jsonPregunta;
    private JacksonTester<Encuesta> jsonEncuesta;


    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this,new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(preguntaRestController).build();
    }
    //-----TEST PARA EL SERVICIO QUE AGREGA UNA NUEVA PREGUNTA-----
    //Caso Positivo
    @Test
    public void siInvocoAddPreguntaYSePuedeAgregarRetornarSatusCreated() throws Exception{
    	// Arrange
    	Pregunta pregunta = getPregunta();
    	given(preguntaService.AddPregunta(pregunta)).willReturn(true);

    	// Act
    	MockHttpServletResponse response = mockMvc
    			.perform(MockMvcRequestBuilders.post("/addPregunta")
    			.accept(MediaType.APPLICATION_JSON)
    			.content(jsonPregunta.write(pregunta).getJson())
    			.contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
                
        // Assert
        assertEquals(HttpStatus.CREATED.value(),response.getStatus());
    }  

	//Caso Negativo
    @Test
    public void siInvocoAddPreguntaYNoSePuedeAgregarRetornarBadRequest() throws Exception{
    	// Arrange
    	Pregunta pregunta = getPregunta();
    	given(preguntaService.AddPregunta(pregunta)).willReturn(false);

    	// Act
    	MockHttpServletResponse response = mockMvc
    			.perform(MockMvcRequestBuilders.post("/alternativa/"+3)
    			.accept(MediaType.APPLICATION_JSON)
    			.content(jsonPregunta.write(pregunta).getJson())
    			.contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
                
        // Assert
        assertEquals(HttpStatus.BAD_REQUEST.value(),response.getStatus());
    }
    
    //-----FIN DEL TEST SERVICIO QUE AGREGA UNA NUEVA ALTERNATIVA-----
    private Pregunta getPregunta() {
		Pregunta pregunta = new Pregunta();
		pregunta.setId(20);
        pregunta.setObligatoria(false);
        pregunta.setOrden(5);
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
