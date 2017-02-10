package co.com.techandsolve.aerotech.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.techandsolve.aerotech.daos.VuelosDao;
import co.com.techandsolve.aerotech.dto.VuelosConsultados;
import co.com.techandsolve.aerotech.models.Aerolinea;
import co.com.techandsolve.aerotech.models.Avion;
import co.com.techandsolve.aerotech.models.Vuelo;

@RunWith(MockitoJUnitRunner.class)
public class VueloConsultadoTest {

	@InjectMocks
	private VueloConsultado vueloConsultado;

	@Mock
	VuelosDao vueloDao;

	@Mock
	List<Vuelo> listaVueloM;

	@Test
	public void debeAdiccionarListaTarifaDeVuelos() {

		VueloConsultado vueloConsultado = new VueloConsultado();
		List<Vuelo> listVuelo = new ArrayList<Vuelo>();
		Avion avion = new Avion();
		Vuelo vuelo = new Vuelo();
		Aerolinea aerolinea = new Aerolinea();

		aerolinea.setNombre("VIVA COLOMBIA");
		avion.setId(123);
		avion.setIdAerolinea(aerolinea);

		vuelo.setId("FKY123");
		vuelo.setIdAvion(avion);
		vuelo.setOrigen("MEDELLIN");
		vuelo.setTarifa(60000);
		vuelo.setDestino("Barranquilla");
		vuelo.setEstado("Disponible");
		vuelo.setFecha(new Date());

		listVuelo.add(vuelo);

		List<VuelosConsultados> listaVuelosConsultadosObtenido = vueloConsultado.addicionarTarifaVuelos(listVuelo);

		assert listaVuelosConsultadosObtenido.size() == 1;
	}

	@Test
	public void debeConsultarTarifaVuelo() {

		String ciudadOrigen = "MEDELLIN";
		String ciudadDestino = "BARRANQUILLA";

		Mockito.when(vueloDao.consultarVuelosSegunCiudades(ciudadOrigen, ciudadDestino)).thenReturn(listaVueloM);

		List<VuelosConsultados> lista = vueloConsultado.addicionarTarifaVuelos(listaVueloM);
		List<VuelosConsultados> listaObtenida = vueloConsultado.consultarTarifaVuelo(ciudadOrigen, ciudadDestino);

		Assert.assertEquals(listaObtenida, lista);
	}

}
