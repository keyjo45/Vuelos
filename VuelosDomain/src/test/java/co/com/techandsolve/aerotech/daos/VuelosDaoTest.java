package co.com.techandsolve.aerotech.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.techandsolve.aerotech.models.Vuelo;

@RunWith(MockitoJUnitRunner.class)
public class VuelosDaoTest {

	@InjectMocks
	VuelosDao vuelosDao;

	@Mock
	EntityManager em;

	@Mock
	TypedQuery<Vuelo> query;

	@Mock
	List<Vuelo> listaVuelos;
	
	@Mock
	Vuelo vuelo;

	@Test
	public void debeConsultarVuelosSegunCiudades() {

		String ciudadOrigen = "MEDELLIN";
		String ciudadDestino = "BARRANQUILLA";

		Mockito.when(em.createNamedQuery(Vuelo.BY_CITY, Vuelo.class)).thenReturn(query);
		Mockito.when(query.setParameter("origen", ciudadOrigen)).thenReturn(query);
		Mockito.when(query.setParameter("destino", ciudadDestino)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(listaVuelos);

		List<Vuelo> listaVueloObtenidos = vuelosDao.consultarVuelosSegunCiudades(ciudadOrigen, ciudadDestino);

		Assert.assertEquals(listaVuelos, listaVueloObtenidos);

	}
	
	@Test
	public void debeConsultarVuelosSegunID() {

		String id = "FKY123";

		Mockito.when(em.createNamedQuery(Vuelo.BY_ID, Vuelo.class)).thenReturn(query);
		Mockito.when(query.setParameter("id", id)).thenReturn(query);
		Mockito.when(query.getSingleResult()).thenReturn(vuelo);

		Vuelo vueloObtenido = vuelosDao.consultarVueloPorID(id);

		Assert.assertEquals(vuelo, vueloObtenido);
		Mockito.verify(query).setParameter("id", id);
	}

}
