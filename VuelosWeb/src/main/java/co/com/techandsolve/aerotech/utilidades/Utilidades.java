package co.com.techandsolve.aerotech.utilidades;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.google.common.hash.Hashing;

import co.com.techandsolve.aerotech.exception.ValidacionException;

public class Utilidades {
	
    public static String generarCodificacion(String password) {
    	return Hashing.sha256().hashString(password, Charset.defaultCharset()).toString();
    }
    
    public  int calcularEdad(String fecha) throws ValidacionException{
        Date fechaNacimientoUsuario=null;
            try {
              
            	fechaNacimientoUsuario = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
            } catch (Exception ex) {
                throw new ValidacionException("Formato noi valido "+ex);
            }
            Calendar fechaNacimiento = Calendar.getInstance();
            Calendar fechaActual = Calendar.getInstance();
            fechaNacimiento.setTime(fechaNacimientoUsuario);
            
            int edad = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
            int month =fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
            int day = fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);
            
            if(month<0 || (month==0 && day<0)){
            	edad--;
            }
            
            return edad;
        }

}
