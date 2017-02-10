package co.com.techandsolve.aerotech.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.techandsolve.aerotech.models.Reserva;
import co.com.techandsolve.aerotech.models.Usuario;

@Stateless
public class ReservaDao {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Reserva> consultarReservaPorIdUsuario(long idUsuario){
		
		Usuario usuario=new Usuario();
		usuario.setId(idUsuario);
	
		return em.createNamedQuery(Reserva.BY_ID_USUARIO, Reserva.class)
		.setParameter("id",  usuario.getId()).getResultList();
		
	}

}
