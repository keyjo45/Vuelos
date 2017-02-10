package co.com.techandsolve.aerotech.daos;

import static org.mockito.Mockito.verify;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import co.com.techandsolve.aerotech.models.Reserva;
import co.com.techandsolve.aerotech.models.Usuario;

@RunWith(MockitoJUnitRunner.class)
public class ReservaDaoTest {

	@InjectMocks
	private ReservaDao reservaDao;

	@Mock
	EntityManager em;

	@Mock
	TypedQuery<Reserva> query;

	@Mock
	List<Reserva> listaReserva;

	@Test
	public void debeConsultarReservaSegunIdUsuario() {

		long idUsuario = 1129572970;

		Usuario usuario = new Usuario();
		usuario.setId(idUsuario);

		Mockito.when(em.createNamedQuery(Reserva.BY_ID_USUARIO, Reserva.class)).thenReturn(query);
		Mockito.when(query.setParameter("id", usuario.getId())).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(listaReserva);

		List<Reserva> listaReservaObtenida = reservaDao.consultarReservaPorIdUsuario(idUsuario);

		Assert.assertEquals(listaReserva, listaReservaObtenida);
		verify(query).setParameter("id", usuario.getId());
	}

}
