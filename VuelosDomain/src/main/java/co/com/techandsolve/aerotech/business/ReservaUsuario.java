package co.com.techandsolve.aerotech.business;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import co.com.techandsolve.aerotech.daos.ReservaDao;
import co.com.techandsolve.aerotech.dto.ReservaCliente;

public class ReservaUsuario {
	
	@Inject
	private ReservaDao reservaDao;
	
	@Inject
	private ReservaClientes reservaClientes;
	
	public List<ReservaCliente> consultarReservaPorIdCliente(long id){
		
		List<ReservaCliente> listReservaCliente=new ArrayList<ReservaCliente>();
		
		listReservaCliente=reservaClientes.adiccionarListaReservaCliente(reservaDao.consultarReservaPorIdUsuario(id));
		
		return listReservaCliente;
		
	}	

}
