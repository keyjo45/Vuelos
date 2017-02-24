package co.com.techandsolve.aerotech.beans;

import static org.mockito.Mockito.never;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.techandsolve.aerotech.daos.UsuarioDao;
import co.com.techandsolve.aerotech.models.Usuario;

@RunWith(MockitoJUnitRunner.class)
public class SecurityBeansTest {

	@InjectMocks
	SecurityBean security;

	@Mock
	Map<String, Usuario> activeAutorizations;

	@Mock
	UsuarioDao usuarioDao;

	@Mock
	Usuario usuarioObtenido;

	@Test
	public void debeLoguotUser() {

		Usuario usuario = new Usuario();
		Mockito.when(activeAutorizations.remove(UUID.randomUUID().toString())).thenReturn(usuario);
		security.loguot(UUID.randomUUID().toString());
		Assert.assertEquals(0, activeAutorizations.size());
		Assert.assertNull(security.loguot(UUID.randomUUID().toString()));
		Mockito.verify(activeAutorizations, never()).remove("fgk");
	}

	@Test
	public void debeCheckPassword() {

		String user = "keyjo45@yahoo.es";
		String password = "123";
		List<Usuario> listaUsuarioObtenido = new ArrayList<>();
		Usuario usuario = new Usuario();
		usuario.setEmail(user);
		usuario.setPassword(password);
		listaUsuarioObtenido.add(usuario);
		Autorizacion autorizacion = new Autorizacion(user, password);
		Mockito.when(usuarioDao.consultarUsuarioPorEmailYPassword(user, password)).thenReturn(listaUsuarioObtenido);
		boolean resultado = security.checkPassword(autorizacion, listaUsuarioObtenido.get(0).getPassword(),
				listaUsuarioObtenido.get(0).getEmail());
		Assert.assertTrue(resultado);
		Mockito.verify(usuarioDao).consultarUsuarioPorEmailYPassword(user, password);
	}

	@Test
	public void debeGenerarToken() {

		String token = UUID.randomUUID().toString();
		Autorizacion autorizacion = new Autorizacion();
		Usuario usuarioPrueba = new Usuario();
		Mockito.when(usuarioDao.consultarUsuarioPorAutorizacion(autorizacion)).thenReturn(usuarioObtenido);
		Mockito.when(activeAutorizations.put(token, usuarioPrueba)).thenReturn(usuarioObtenido);
		Usuario usuario = security.generateToken(autorizacion);
		Assert.assertEquals(usuarioObtenido, usuario);
		Mockito.verify(usuarioDao).consultarUsuarioPorAutorizacion(autorizacion);
		Mockito.verify(activeAutorizations, never()).put(token, new Usuario());
	}
	
	@Test
	public void debeGenerarRuntimeException(){
		
		RuntimeException runException= security.getLoginEx();
		Assert.assertNotNull(runException);
	}
}
