package com.teamxploitdx.proyecto_ubb.Rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.teamxploitdx.proyecto_ubb.Service.EncuestaService;
import com.teamxploitdx.proyecto_ubb.Service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamxploitdx.proyecto_ubb.Model.Empresa;
import com.teamxploitdx.proyecto_ubb.Model.Usuario;
import org.springframework.mock.web.MockHttpServletResponse;
import com.teamxploitdx.proyecto_ubb.Repository.EmpresaRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


@ExtendWith (MockitoExtension.class)
public class UsuarioRestControllerTest {
    
    @Mock
    private UsuarioService usuarioService;
    @Mock
    private EncuestaService encuestaService;
    @Mock
    private EmpresaRepository empresaRepository;
    @InjectMocks
    private UsuarioRestController UsuarioRestController;

    private MockMvc mockMvc;

	private JacksonTester<Usuario> jsonUsuario;
    
    
    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this,new ObjectMapper());
        mockMvc = MockMvcBuilders.standaloneSetup(UsuarioRestController).build();
    }

    // @Test
    // public void siInvocoAddEmpresaYUsuarioYEmpresaExistenEntoncesRetornaStatusOk () throws Exception{
    //     //Arrange
    //     Empresa empresa = getEmpresa();
    //     Usuario usuario = getUsuario();
    //     given(usuarioService.AddEmpresa(usuario.getId(),empresa.getId())).willReturn(true);
       
    //     //Act
    //     MockHttpServletResponse response = mockMvc
    //         .perform(MockMvcRequestBuilders.post("/addEmpresa/"+empresa.getId()+"/empresa/"+usuario.getId())
    //         .accept(MediaType.APPLICATION_JSON)
    //         .content(jsonUsuario.write(usuario).getJson())
    //         .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

    //     // Assert
    //     assertEquals(HttpStatus.OK.value(),response.getStatus());
    // }
    // @Test
    // public void siInvocoAddEmpresaYNoExisteEmpresaOUsuarioEntoncesRetornaStatusBadRequest () throws Exception{
    //     //Arrange
    //     Empresa empresa = getEmpresa();
    //     Usuario usuario = getUsuario();
    //     given(usuarioService.AddEmpresa(usuario.getId(),empresa.getId())).willReturn(false);
       
    //     //Act
    //     MockHttpServletResponse response = mockMvc
    //         .perform(MockMvcRequestBuilders.post("/addEmpresa/"+empresa.getId()+"/empresa/"+usuario.getId())
    //         .accept(MediaType.APPLICATION_JSON)
    //         .content(jsonUsuario.write(usuario).getJson())
    //         .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

    //     // Assert
    //     assertEquals(HttpStatus.BAD_REQUEST.value(),response.getStatus());
    // }


    private Empresa getEmpresa(){
        Empresa empresa = new Empresa (12,"empresa","correo@gmail.com","descripcion");
        return empresa;
    }
    private Usuario getUsuario(){
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setNombre("nombre");
        usuario.setApellido("apellido");
        usuario.setEmail("correo@gmail.com");
        return usuario;
    }
    

}
