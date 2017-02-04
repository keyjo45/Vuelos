package co.com.techandsolve.aerotech.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import co.com.techandsolve.aerotech.dto.ReservaCliente;
import co.com.techandsolve.aerotech.models.Avion;
import co.com.techandsolve.aerotech.models.Reserva;
import co.com.techandsolve.aerotech.models.Usuario;
import co.com.techandsolve.aerotech.models.Vuelo;

public class ReservaClientesTest {
	
	@Test
	public void debeAdiccionarListaReservaCliente(){
		
		
		ReservaClientes reservaClientes=new ReservaClientes();
		List<ReservaCliente> listReservasObtenida=new ArrayList<ReservaCliente>();
		List<Reserva> listReservaVuelo= new ArrayList<Reserva>();
		List<Reserva> listReserva= new ArrayList<Reserva>();
		Reserva reserva=new Reserva();
		Vuelo vuelo=new Vuelo();
		
		
		vuelo.setId("FKY123");
		vuelo.setIdAvion(new Avion());
		vuelo.setOrigen("MEDELLIN");
		vuelo.setReservas(listReservaVuelo);
		vuelo.setTarifa(60000);
		vuelo.setDestino("Barranquilla");
		vuelo.setEstado("Disponible");
		vuelo.setFecha(new Date());
		
		
		reserva.setId(3);
		reserva.setFechaReserva(new Date());
		reserva.setIdUsuario(new Usuario());
		reserva.setIdVuelo(vuelo);
		
		listReserva.add(reserva);			
		
		listReservasObtenida=reservaClientes.adiccionarListaReservaCliente(listReserva);
		
		
		assert listReservasObtenida.size() == 1;
		
	}

}
