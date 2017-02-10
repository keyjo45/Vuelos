package co.com.techandsolve.aerotech.daos;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
	public void debeCrearUsuario(){
		
		Usuario usuarioCreado = new Usuario();
		usuarioDao.crearUsuario(usuarioCreado);;
		verify(em).persist(usuarioCreado);
	}
	
	@Test
	public void debeConsultarUsuario(){

		List<Usuario> listUsuarioObtenido =new ArrayList<Usuario>();
		
		Usuario usuarioObtenido = new Usuario();
				
		
		when(em.createNamedQuery(Usuario.USUARIO_ENCONTRADO, Usuario.class)).thenReturn(query);
		when(query.setParameter("id", usuarioObtenido.getId())).thenReturn(query);
		when(query.setParameter("email", usuarioObtenido.getEmail())).thenReturn(query);
		when(query.setParameter("password", usuarioObtenido.getPassword())).thenReturn(query);
		when(query.getResultList()).thenReturn(listUsuario);
		
		listUsuarioObtenido=usuarioDao.consultarUsuario(usuarioObtenido);
		
		assertEquals(listUsuario,listUsuarioObtenido);
		verify(query).setParameter("id", usuarioObtenido.getId());
		
	}
	
	@Test
	public void debeConsultarUsuarioPorEmailYPassword(){

		List<Usuario> listUsuarioObtenido =new ArrayList<Usuario>();
		
		String user="keyjo45@yahoo.es";
		String password="PrvEaec5j4XWFJS3P0+dUw==";
		
		when(em.createNamedQuery(Usuario.BY_EMAIL_PASSWORD, Usuario.class)).thenReturn(query);
		when(query.setParameter("email", user)).thenReturn(query);
		when(query.setParameter("password", password)).thenReturn(query);
		when(query.getResultList()).thenReturn(listUsuario);
		
		listUsuarioObtenido=usuarioDao.consultarUsuarioPorEmailYPassword(user, password);
		
		assertEquals(listUsuario,listUsuarioObtenido);
		verify(query).setParameter("email", user);
		
	}

}
