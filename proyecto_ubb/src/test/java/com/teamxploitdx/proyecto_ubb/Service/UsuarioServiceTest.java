package com.teamxploitdx.proyecto_ubb.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.teamxploitdx.proyecto_ubb.Model.Empresa;
import com.teamxploitdx.proyecto_ubb.Model.Usuario;
import com.teamxploitdx.proyecto_ubb.Repository.EmpresaRepository;
import com.teamxploitdx.proyecto_ubb.Repository.UsuarioRepository;


@ExtendWith (MockitoExtension.class)
public class UsuarioServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;
    @Mock
    private EmpresaRepository empresaRepository;

    @InjectMocks
    private UsuarioService usuarioService;
    

    @Test
    public void siInvocoFindALlUsuarioYHayUsuariosEntoncesRetornaTodasLasEncuestas(){

        //Arrange
        List <Usuario> usuario = new ArrayList<>();
        usuario.add(getUsuario());
    
        when(usuarioRepository.findAll()).thenReturn(usuario);

        //Act
        List <Usuario> resultado = usuarioService.findAllusuarios();
        
        //Assert
        assertEquals(resultado, usuario);

    }
    @Test
    public void siInvocoFindALlUsuariosYNoHayUsuariosEntoncesRetornaLaListaVacia(){

        //Arrange
        when(usuarioRepository.findAll()).thenReturn(new ArrayList<>());

        //Act
        List <Usuario> resultado = usuarioService.findAllusuarios();
        
        //Assert
        assertTrue(resultado.isEmpty());

    }

    @Test
    public void siInvocoAddEmpresaYExisteEmpresaYUsuarioEntoncesRetornaTrue(){

        Empresa empresa = getEmpresa();
        Usuario usuario = getUsuario();

        when(empresaRepository.findById(1)).thenReturn(Optional.of(empresa));
        when(usuarioRepository.findById(1)).thenReturn(Optional.of(usuario));

        boolean resultado = usuarioService.AddEmpresa(1, 1);

        assertTrue(resultado);
        assertEquals(usuario.getEmpresa(),empresa);

    }

    @Test
    public void siInvocoAddempresaYNoExisteEmpresaOUsuarioEntoncesRetornaFalse(){

        boolean resultado = usuarioService.AddEmpresa(1, 1);

        assertFalse(resultado);

    }

    @Test
    public void siInvocoFindUsuarioByIdYExisteElUsuarioEntoncesRetornaElUsuario(){

        Optional<Usuario> usuario = Optional.of(getUsuario());

        when(usuarioRepository.findById(1)).thenReturn((usuario));

        Optional<Usuario> usuarioPrueba = usuarioService.findUsuarioById(1);

        assertEquals(usuario, usuarioPrueba);
    }





    public Usuario getUsuario(){
        Usuario usuario = new Usuario();

        usuario.setId(1);
        usuario.setNombre("nombre");
        usuario.setApellido("apellido");
        usuario.setEmail("email");
        return usuario;
    }

    public Empresa getEmpresa(){

        Empresa empresa = new Empresa();

        empresa.setId(1);
        empresa.setNombre("null");
        empresa.setEmail("null");
        empresa.setDescripcion("null");

        return empresa;
    }

}
