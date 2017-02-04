package co.com.techandsolve.aerotech.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.techandsolve.aerotech.models.Vuelo;

public class VuelosDao {
	
	@PersistenceContext
	EntityManager em;
	
	
	public List<Vuelo> consultarReservaPorIdUsuario(String id){
			return em.createQuery(" SELECT v.* FROM vuelo v WHERE v.id= ? ", Vuelo.class)
		.setParameter(1,  id).getResultList();
		
		
	}

}
