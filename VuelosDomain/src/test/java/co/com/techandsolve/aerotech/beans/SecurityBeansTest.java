package co.com.techandsolve.aerotech.beans;

import static org.mockito.Mockito.never;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
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
	
	private Usuario usuario;
	private List<Usuario> listaUsuarioObtenido;
	private String user, password;
	private Autorizacion autorizacion;
	
	@InjectMocks
	SecurityBean security;

	@Mock
	Map<String, Usuario> activeAutorizations;

	@Mock
	UsuarioDao usuarioDao;
	
	@Before
	public void setUp(){
		
		user = "keyjo45@yahoo.es";
		password = "123";
		usuario = new Usuario();
		usuario.setApellidos("Valega");
		usuario.setEmail(user);
		usuario.setFechaNacimiento(new Date());
		usuario.setGenero("M");
		usuario.setNombres("Yosimar");
		usuario.setId(12);
		usuario.setTelefono(3230321);
		usuario.setPassword(password);
		autorizacion = new Autorizacion(user, password);
		listaUsuarioObtenido = new ArrayList<>();
		listaUsuarioObtenido.add(usuario);
		Mockito.when(usuarioDao.consultarUsuarioPorEmailYPassword(user, password)).thenReturn(listaUsuarioObtenido);
	}

	@Test
	public void debeLoguotUser() {

		Mockito.when(activeAutorizations.remove(UUID.randomUUID().toString())).thenReturn(usuario);
		security.loguot(UUID.randomUUID().toString());
		Assert.assertEquals(0, activeAutorizations.size());
		Assert.assertNull(security.loguot(UUID.randomUUID().toString()));
		Mockito.verify(activeAutorizations, never()).remove("fgk");
	}

	@Test
	public void debeCheckPassword() {

		
		boolean resultado = security.checkPassword(autorizacion, listaUsuarioObtenido.get(0).getPassword(),
				listaUsuarioObtenido.get(0).getEmail());
		Assert.assertTrue(resultado);
		Mockito.verify(usuarioDao).consultarUsuarioPorEmailYPassword(user, password);
	}

	@Test
	public void debeGenerarToken() {
		
		Mockito.when(usuarioDao.consultarUsuarioPorAutorizacion(autorizacion)).thenReturn(usuario);
		Usuario usuarioObtenido = security.generateToken(autorizacion);
		Assert.assertEquals(usuario, usuarioObtenido);
		Mockito.verify(usuarioDao).consultarUsuarioPorAutorizacion(autorizacion);
	}

	@Test
	public void debeGenerarRuntimeException() {

		RuntimeException runException = security.getLoginEx();
		Assert.assertNotNull(runException);
	}

	@Test
	public void debeLoguearse() {

		Mockito.when(usuarioDao.consultarUsuarioPorAutorizacion(Mockito.any(Autorizacion.class))).thenReturn(usuario);
		Usuario usarioResultante = security.login(user, password);
		Assert.assertEquals(usuario, usarioResultante);
		Mockito.verify(usuarioDao).consultarUsuarioPorEmailYPassword(user, password);
		Mockito.verify(usuarioDao).consultarUsuarioPorAutorizacion(Mockito.any(Autorizacion.class));
	}
}
