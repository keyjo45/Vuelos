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
	
		return em.createQuery(" SELECT r FROM Reserva r JOIN FETCH r.idVuelo JOIN FETCH r.idUsuario usuario WHERE usuario.id=:id ", Reserva.class)
		.setParameter("id",  usuario.getId()).getResultList();
		
	}

}
