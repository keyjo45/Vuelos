package co.com.techandsolve.aerotech.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.techandsolve.aerotech.business.ReservaUsuario;
import co.com.techandsolve.aerotech.dto.ReservaCliente;

@RunWith(MockitoJUnitRunner.class)
public class ReservaServicesTest {
	
	@InjectMocks
	private ReservaServices reservasService;
	
	@Mock
	private ReservaUsuario reservaUsuario;
	
	@Mock
	private List<ReservaCliente> listReservaCliente;
	
	
	
	@Test
	public void debeLlamarConsultarReserva(){
		
		List<ReservaCliente> listReservaClienteObtenida=new ArrayList<ReservaCliente>();
		
		long id=1129572970;
		
		Mockito.when(reservaUsuario.consultarReservaPorIdCliente(id)).thenReturn(listReservaCliente);
		
		listReservaClienteObtenida=reservasService.consultarReserva(id);
		
		//assert
		Mockito.verify(reservaUsuario).consultarReservaPorIdCliente(id);
		Assert.assertEquals(listReservaCliente, listReservaClienteObtenida);
		
	}

}
