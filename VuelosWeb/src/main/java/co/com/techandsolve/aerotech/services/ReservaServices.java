package co.com.techandsolve.aerotech.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.techandsolve.aerotech.business.ReservaUsuario;
import co.com.techandsolve.aerotech.dto.ReservaCliente;

@Path("/reserva")
public class ReservaServices {
	
	@Inject
	private ReservaUsuario reservaUsuario;
	
	@GET
	@Path("/consultarReservas/{id}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReservaCliente> consultarReserva(@PathParam("id") long id){
		return reservaUsuario.consultarReservaPorIdCliente(id);
	}

}
