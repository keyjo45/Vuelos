package co.com.techandsolve.aerotech.daos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.techandsolve.aerotech.models.Vuelo;

@Stateless
public class VuelosDao {

	@PersistenceContext
	EntityManager em;

	public List<Vuelo> consultarVuelosSegunCiudades(String ciudadOrigen, String ciudadDestino) {

		return em.createNamedQuery(Vuelo.BY_CITY, Vuelo.class).setParameter("origen", ciudadOrigen)
				.setParameter("destino", ciudadDestino).getResultList();
	}

	public Vuelo consultarVueloPorID(String id) {

		return em.createNamedQuery(Vuelo.BY_ID, Vuelo.class).setParameter("id", id).getSingleResult();
	}
}
