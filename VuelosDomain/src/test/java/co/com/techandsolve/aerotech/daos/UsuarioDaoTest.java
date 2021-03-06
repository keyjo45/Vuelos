package co.com.techandsolve.aerotech.daos;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.techandsolve.aerotech.beans.Autorizacion;
import co.com.techandsolve.aerotech.models.Usuario;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioDaoTest {

	@InjectMocks
	private UsuarioDao usuarioDao;

	@Mock
	EntityManager em;

	@Mock
	TypedQuery<Usuario> query;

	@Mock
	private List<Usuario> listUsuario;

	@Test
	public void debeCrearUsuario() {

		Usuario usuarioCreado = new Usuario();
		usuarioCreado.setId(123);
		usuarioCreado.setApellidos("VALEGA");
		usuarioCreado.setFechaNacimiento(new Date());
		usuarioCreado.setGenero("F");
		usuarioCreado.setNombres("YOSIMAR ENRIQUE");
		usuarioCreado.setPassword("123");
		usuarioCreado.setTelefono(3230321);
		usuarioDao.crearUsuario(usuarioCreado);
		verify(em).persist(usuarioCreado);
		Assert.assertEquals("YOSIMAR ENRIQUE", usuarioCreado.getNombres());
	}

	@Test
	public void debeConsultarUsuario() {

		List<Usuario> listUsuarioObtenido = new ArrayList<Usuario>();

		Usuario usuarioObtenido = new Usuario();

		when(em.createNamedQuery(Usuario.USUARIO_ENCONTRADO, Usuario.class)).thenReturn(query);
		when(query.setParameter("id", usuarioObtenido.getId())).thenReturn(query);
		when(query.setParameter("email", usuarioObtenido.getEmail())).thenReturn(query);
		when(query.setParameter("password", usuarioObtenido.getPassword())).thenReturn(query);
		when(query.getResultList()).thenReturn(listUsuario);

		listUsuarioObtenido = usuarioDao.consultarUsuario(usuarioObtenido);

		assertEquals(listUsuario, listUsuarioObtenido);
		verify(query).setParameter("id", usuarioObtenido.getId());

	}

	@Test
	public void debeConsultarUsuarioPorEmailYPassword() {

		List<Usuario> listUsuarioObtenido = new ArrayList<Usuario>();

		String user = "keyjo45@yahoo.es";
		String password = "PrvEaec5j4XWFJS3P0+dUw==";

		when(em.createNamedQuery(Usuario.BY_EMAIL, Usuario.class)).thenReturn(query);
		when(query.setParameter("email", user)).thenReturn(query);
		when(query.setParameter("password", password)).thenReturn(query);
		when(query.getResultList()).thenReturn(listUsuario);

		listUsuarioObtenido = usuarioDao.consultarUsuarioPorEmailYPassword(user, password);

		assertEquals(listUsuario, listUsuarioObtenido);
		verify(query).setParameter("email", user);

	}

	@Test
	public void debeConsultarUsuarioPorAutorizacion() {

		Autorizacion autorizacion = new Autorizacion();
		Usuario usuario = new Usuario();

		when(em.createNamedQuery(Usuario.BY_AUTORIZACION, Usuario.class)).thenReturn(query);
		when(query.setParameter("email", autorizacion.getUserName())).thenReturn(query);
		when(query.getSingleResult()).thenReturn(usuario);

		Usuario usuarioObtenido = usuarioDao.consultarUsuarioPorAutorizacion(autorizacion);

		assertEquals(usuario, usuarioObtenido);
		verify(query).setParameter("email", autorizacion.getUserName());

	}

}
