package co.com.techandsolve.aerotech.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.techandsolve.aerotech.business.VueloConsultado;
import co.com.techandsolve.aerotech.dto.VuelosConsultados;

@RunWith(MockitoJUnitRunner.class)
public class VuelosServicesTest {

	@InjectMocks
	VuelosServices vuelosServices;

	@Mock
	VueloConsultado vueloFacade;

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

}
