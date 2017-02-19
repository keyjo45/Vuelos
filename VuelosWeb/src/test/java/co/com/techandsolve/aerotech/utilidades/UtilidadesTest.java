package co.com.techandsolve.aerotech.utilidades;

import java.text.ParseException;
import org.junit.Assert;
import org.junit.Test;
import co.com.techandsolve.aerotech.exception.ValidacionException;

public class UtilidadesTest {
	


	@Test
	public void debeCalcularEdaddeUsuario() throws ParseException, ValidacionException {

		String fechaNacimiento = "13-11-1986";
		
		int edad = Utilidades.calcularEdad(fechaNacimiento.toString());

		Assert.assertEquals(30, edad);
	}
	
	@Test(expected=ValidacionException.class)
	public void debeValidarExceptionCalcularEdad() throws ValidacionException {
		String fecha="";
		Utilidades.calcularEdad(fecha);
	}

	

	@Test
	public void debeEncriptarPassword() throws ParseException {

		String password = "lazaro123";
		String pass = Utilidades.generarCodificacion(password);

		Assert.assertNotEquals("Error", pass, password);
	}

}
