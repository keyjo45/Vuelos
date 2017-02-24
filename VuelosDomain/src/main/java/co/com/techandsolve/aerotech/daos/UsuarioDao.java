package co.com.techandsolve.aerotech.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import co.com.techandsolve.aerotech.beans.Autorizacion;
import co.com.techandsolve.aerotech.models.Usuario;


@Stateless
public class UsuarioDao {
	
	@PersistenceContext
	EntityManager em;
	
	private TypedQuery<Usuario> query;
		
	public void crearUsuario(Usuario usuarioCreado){
		em.persist(usuarioCreado);
	}
	
	public List<Usuario> consultarUsuario(Usuario usuarioCreado){
		query=em.createNamedQuery(Usuario.USUARIO_ENCONTRADO, Usuario.class);
		query.setParameter("id",  usuarioCreado.getId());
		query.setParameter("email",  usuarioCreado.getEmail());
		query.setParameter("password",  usuarioCreado.getPassword());
		return query.getResultList();
	}
	
	public List<Usuario> consultarUsuarioPorEmailYPassword(String user, String password){
		query=em.createNamedQuery(Usuario.BY_EMAIL_PASSWORD, Usuario.class);
		query.setParameter("email",  user);
		query.setParameter("password",  password);
		return query.getResultList();
	}
	
	public Usuario consultarUsuarioPorAutorizacion(Autorizacion autorizacion){
		query=em.createNamedQuery(Usuario.BY_AUTORIZACION, Usuario.class);
		query.setParameter("email",  autorizacion.getUserName());
		return query.getSingleResult();
	}

}
