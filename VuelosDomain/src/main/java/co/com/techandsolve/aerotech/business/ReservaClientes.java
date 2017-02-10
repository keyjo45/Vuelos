package co.com.techandsolve.aerotech.business;

import java.util.ArrayList;
import java.util.List;

import co.com.techandsolve.aerotech.dto.ReservaCliente;
import co.com.techandsolve.aerotech.models.Reserva;

public class ReservaClientes {
	
	public List<ReservaCliente> adiccionarListaReservaCliente(List<Reserva> listReserva){
		
		List<ReservaCliente> listReservas = new ArrayList<>();

		listReserva.forEach(obj -> listReservas.add(new ReservaCliente(obj)));

		return listReservas;
	}

}
