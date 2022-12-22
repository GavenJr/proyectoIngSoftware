package com.teamxploitdx.proyecto_ubb.Rest;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

import static org.mockito.BDDMockito.given;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamxploitdx.proyecto_ubb.Model.Encuesta;
import com.teamxploitdx.proyecto_ubb.Service.EncuestaService;

@ExtendWith (MockitoExtension.class)
public class EncuestaRestControllerTest {
     
    @Mock
    private EncuestaService encuestaService;

    @InjectMocks
    private EncuestadoRestController encuestaRestController;
    
    private MockMvc mockMvc;
    
    private JacksonTester<Encuesta> jEncuesta;
    
    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this,new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(encuestaRestController).build();
    }
    
    // @Test
    // public void siInvocoCambiarVisibilidadEntoncesCambiaVisibilidadYRetornaOk () throws Exception{
    //     //Arrange
    //     Encuesta encuesta = getEncuesta();
    //     given(encuestaService.updateVisibilidad(encuesta.getId())).willReturn(true);     
    //     //Act
    //     MockHttpServletResponse response = mockMvc
    //         .perform(MockMvcRequestBuilders.patch("/encuestas/cambiarVisibilidad/"+encuesta.getId())
    //         .accept(MediaType.APPLICATION_JSON)
    //         .content(jEncuesta.write(encuesta).getJson())
    //         .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

    //     // Assert
    //     assertEquals(HttpStatus.OK.value(),response.getStatus());
    // }

    // @Test
    // public void siInvocoCambiarVisibilidadEntoncesNoCambiaVisibilidadYRetornaBadRequest () throws Exception{
    //     //Arrange
    //     Encuesta encuesta = getEncuesta();
    //     given(encuestaService.updateVisibilidad(encuesta.getId())).willReturn(false);     
    //     //Act
    //     MockHttpServletResponse response = mockMvc
    //         .perform(MockMvcRequestBuilders.patch("/encuestas/cambiarVisibilidad/"+encuesta.getId())
    //         .accept(MediaType.APPLICATION_JSON)
    //         .content(jEncuesta.write(encuesta).getJson())
    //         .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

    //     // Assert
    //     assertEquals(HttpStatus.BAD_REQUEST.value(),response.getStatus());
    // }
    // @Test
    // public void siInvocoCambiarDescripcionEntoncesCambiaDescripcionYRetornaStatusOk () throws Exception{
    //     //Arrange
    //     Encuesta encuesta = getEncuesta();
    //     given(encuestaService.updateDescripcion(encuesta.getId(), encuesta.getDescripcion())).willReturn(true);     
    //     //Act
    //     MockHttpServletResponse response = mockMvc
    //         .perform(MockMvcRequestBuilders.post("/encuestas/cambiarDescripcion/"+encuesta.getId())
    //         .accept(MediaType.APPLICATION_JSON)
    //         .content(jEncuesta.write(encuesta).getJson())
    //         .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();
    //     // Assert
    //     assertEquals(HttpStatus.OK.value(),response.getStatus());
    // }


    private Encuesta getEncuesta(){
        Encuesta encuesta = new Encuesta();
        encuesta.setId(1);
        encuesta.setVisible(false);
        encuesta.setDescripcion("null");
        return encuesta;
    }
}
