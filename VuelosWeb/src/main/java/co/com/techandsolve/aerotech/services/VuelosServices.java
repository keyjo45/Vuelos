package co.com.techandsolve.aerotech.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import co.com.techandsolve.aerotech.business.VueloConsultado;
import co.com.techandsolve.aerotech.daos.VuelosDao;
import co.com.techandsolve.aerotech.dto.VuelosConsultados;
import co.com.techandsolve.aerotech.exception.ValidacionException;
import co.com.techandsolve.aerotech.models.Vuelo;

@Path("/vuelo")
public class VuelosServices {
	
	private static final Logger LOGGER = (Logger)  LoggerFactory.getLogger(VuelosServices.class);

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
	public Vuelo consultarTarifasVuelosPorId(@PathParam("id") String id) throws ValidacionException {
		
		try{
			return vueloDao.consultarVueloPorID(id);
		}catch (Exception e) {
			LOGGER.info("Vuelo: NO SE ENCONTRARON VUELOS ", e.getMessage());
			throw new ValidacionException ("NO SE ENCONTRARON VUELOS: ");
		}
	}

}
