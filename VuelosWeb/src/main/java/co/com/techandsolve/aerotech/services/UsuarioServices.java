package co.com.techandsolve.aerotech.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.com.techandsolve.aerotech.beans.SecurityBean;
import co.com.techandsolve.aerotech.daos.UsuarioDao;
import co.com.techandsolve.aerotech.exception.ValidacionException;
import co.com.techandsolve.aerotech.models.Usuario;
import co.com.techandsolve.aerotech.utilidades.Utilidades;

@Path("/usuario")
public class UsuarioServices {
	
	@Inject
	private UsuarioDao usuarioDao;
	
	@Inject
	SecurityBean securityBean;
	
	
	private List<Usuario> listUsuario=new ArrayList<>();
	
	@PUT
	@Path("/saveUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addClient(@Valid Usuario usuario) throws ValidacionException {
		
		String password = Utilidades.generarCodificacion(usuario.getPassword());
		usuario.setPassword(password);
		
		listUsuario=usuarioDao.consultarUsuario(usuario);
		
		if(listUsuario.isEmpty()){
			usuarioDao.crearUsuario(usuario);
		}else{
			throw new ValidacionException ("Usuario creado anteriormente: Ya existe un usuario para la identificaci�n: "+usuario.getId()+", el email: "+usuario.getEmail()+" y password");
		}
		
	}
	
	@POST
	@Path("/login/{usuario}/{password}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario login(@PathParam("usuario") String usuario, @PathParam("password") String password) throws ValidacionException {
		
		try{
			String passwordEncript = Utilidades.generarCodificacion(password);
			return securityBean.login(usuario, passwordEncript);
		}catch (Exception e) {
			throw new ValidacionException("Credenciales no validas "+e);
		}
		
	}

}