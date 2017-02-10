package co.com.techandsolve.aerotech.business;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.com.techandsolve.aerotech.daos.VuelosDao;
import co.com.techandsolve.aerotech.dto.VuelosConsultados;
import co.com.techandsolve.aerotech.models.Vuelo;

public class VueloConsultado {
	
	@Inject
	VuelosDao vuelosDao;
	
	public List<VuelosConsultados> consultarTarifaVuelo(String ciudadOrigen, String ciudadDestino){

		return addicionarTarifaVuelos(vuelosDao.consultarVuelosSegunCiudades(ciudadOrigen, ciudadDestino));
	}
	
	public List<VuelosConsultados> addicionarTarifaVuelos(List<Vuelo> listaVuelo){
		
		List<VuelosConsultados> listaVuelosConsultados = new ArrayList<>();
		listaVuelo.forEach(obj -> listaVuelosConsultados.add(new VuelosConsultados(obj)));

		return listaVuelosConsultados;
	}

}
