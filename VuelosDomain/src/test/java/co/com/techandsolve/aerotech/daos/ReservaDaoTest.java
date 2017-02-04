package co.com.techandsolve.aerotech.daos;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.techandsolve.aerotech.models.Reserva;

@RunWith(MockitoJUnitRunner.class)
public class ReservaDaoTest {
	
	@InjectMocks
	private ReservaDao reservaDao;
	
	@Mock
	EntityManager em;
	
	@Mock
	TypedQuery<Reserva> query;
	
	@Mock
	List<Reserva> listReserva;
	
	@Test
	public void debeConsultarReservaSegunIdUsuario(){

			List<Reserva> listReservaObtenido =new ArrayList<Reserva>();
			
			long idUsuario=1129572970;
			
			when(em.createNamedQuery(Reserva.BY_ID_USUARIO, Reserva.class)).thenReturn(query);
			when(query.setParameter("idUsuario", idUsuario)).thenReturn(query);
			when(query.getResultList()).thenReturn(listReserva);
			
			listReservaObtenido=reservaDao.consultarReservaPorIdUsuario(idUsuario);
			
			assertEquals(listReserva,listReservaObtenido);
			verify(query).setParameter("idUsuario", idUsuario);
			
	}

}
