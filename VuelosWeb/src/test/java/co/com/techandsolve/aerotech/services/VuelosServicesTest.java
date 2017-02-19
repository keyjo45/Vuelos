package co.com.techandsolve.aerotech.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.techandsolve.aerotech.business.VueloConsultado;
import co.com.techandsolve.aerotech.daos.VuelosDao;
import co.com.techandsolve.aerotech.dto.VuelosConsultados;
import co.com.techandsolve.aerotech.exception.ValidacionException;
import co.com.techandsolve.aerotech.models.Vuelo;

@RunWith(MockitoJUnitRunner.class)
public class VuelosServicesTest {

	@InjectMocks
	VuelosServices vuelosServices;

	@Mock
	VueloConsultado vueloFacade;

	@Mock
	VuelosDao vueloDao;

	@Mock
	Vuelo vueloM;

	@Mock
	List<VuelosConsultados> listaVuelos;

	@Test
	public void debeConsultarTarifasDeVuelos() {

		String ciudadOrigen = "BARRANQUILLA";
		String ciudadDestino = "MEDELLIN";
		Mockito.when(vueloFacade.consultarTarifaVuelo(ciudadOrigen, ciudadDestino)).thenReturn(listaVuelos);
		List<VuelosConsultados> listaObtenida = vuelosServices.consultarTarifasVuelos(ciudadOrigen, ciudadDestino);
		Assert.assertEquals(listaVuelos, listaObtenida);
		Mockito.verify(vueloFacade).consultarTarifaVuelo(ciudadOrigen, ciudadDestino);
	}

	@Test
	public void debeConsultarTarifasVuelosPorID() throws ValidacionException {

		String idVuelo = "FKY123";

		Mockito.when(vueloDao.consultarVueloPorID(idVuelo)).thenReturn(vueloM);
		Vuelo vueloObtenido = vuelosServices.consultarTarifasVuelosPorId(idVuelo);
		Assert.assertEquals(vueloM, vueloObtenido);
		Mockito.verify(vueloDao).consultarVueloPorID(idVuelo);
	}

}
