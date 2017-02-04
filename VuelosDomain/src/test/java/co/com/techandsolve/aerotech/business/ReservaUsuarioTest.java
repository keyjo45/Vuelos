package co.com.techandsolve.aerotech.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.techandsolve.aerotech.daos.ReservaDao;
import co.com.techandsolve.aerotech.dto.ReservaCliente;
import co.com.techandsolve.aerotech.models.Reserva;

@RunWith(MockitoJUnitRunner.class)
public class ReservaUsuarioTest {
	
	@InjectMocks
	private ReservaUsuario reservaUsuarioReserva;
	
	@Mock
	private ReservaDao reservaDao;
	
	@Mock
	private ReservaClientes reservaClientes;
	
	@Mock
	private List<Reserva> listReservaActual;
	
	@Mock
	private List<ReservaCliente> listReservaClienteActual;
	
	
	
	@Test
	public void debeConsultarReservaPorIdCliente(){
		
		long idCliente=1129572970;
		
		List<ReservaCliente> listReservaClienteObtenida=new ArrayList<ReservaCliente>();
		
		Mockito.when(reservaDao.consultarReservaPorIdUsuario(idCliente)).thenReturn(listReservaActual);
		
		Mockito.when(reservaClientes.adiccionarListaReservaCliente(listReservaActual)).thenReturn(listReservaClienteActual);
		
		listReservaClienteObtenida=reservaUsuarioReserva.consultarReservaPorIdCliente(idCliente);
		
		//assert
		Mockito.verify(reservaDao).consultarReservaPorIdUsuario(idCliente);
		Mockito.verify(reservaClientes).adiccionarListaReservaCliente(listReservaActual);
		Assert.assertEquals(listReservaClienteObtenida, listReservaClienteActual);
		
	}

}
