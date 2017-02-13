package co.com.techandsolve.aerotech.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.techandsolve.aerotech.business.VueloConsultado;
import co.com.techandsolve.aerotech.daos.VuelosDao;
import co.com.techandsolve.aerotech.dto.VuelosConsultados;
import co.com.techandsolve.aerotech.models.Vuelo;

@Path("/vuelo")
public class VuelosServices {

	@Inject
	VueloConsultado vueloFacade;

	@Inject
	VuelosDao vueloDao;

	@GET
	@Path("/consultarVuelos/{ciudadOrigen}/{ciudadDestino}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<VuelosConsultados> consultarTarifasVuelos(@PathParam("ciudadOrigen") String ciudadOrigen,
			@PathParam("ciudadDestino") String ciudadDestino) {

		return vueloFacade.consultarTarifaVuelo(ciudadOrigen, ciudadDestino);
	}

	@GET
	@Path("/consultarEstadoVuelo/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Vuelo consultarTarifasVuelosPorId(@PathParam("id") String id) {

		return vueloDao.consultarVueloPorID(id);
	}

}
