package co.com.techandsolve.aerotech.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.techandsolve.aerotech.daos.UsuarioDao;
import co.com.techandsolve.aerotech.exception.ValidacionException;
import co.com.techandsolve.aerotech.models.Usuario;
import co.com.techandsolve.aerotech.utilidades.Utilidades;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceTest {

	@InjectMocks
	private UsuarioServices usuarioServices;
	
	@Mock
	UsuarioDao usuarioDao;
	
	
	@Test
	public void debeAdicionarCliente() throws ValidacionException{
		
		Usuario usuario = new Usuario();
		usuario.setPassword(Utilidades.generarCodificacion("1234"));
		List<Usuario> listaUsuario = new ArrayList<>();
		Mockito.when(usuarioDao.consultarUsuario(usuario)).thenReturn(listaUsuario);
		usuarioServices.addClient(usuario);
		Mockito.verify(usuarioDao).crearUsuario(usuario);	
	}
	
	@Test(expected=ValidacionException.class)
	public void noDebeAdicionarCliente() throws ValidacionException{
		
		Usuario usuario = new Usuario();
		usuario.setPassword(Utilidades.generarCodificacion("1234"));
		List<Usuario> listaUsuario = Arrays.asList(new Usuario());
		Mockito.when(usuarioDao.consultarUsuario(usuario)).thenReturn(listaUsuario);
		usuarioServices.addClient(usuario);
	}
}
