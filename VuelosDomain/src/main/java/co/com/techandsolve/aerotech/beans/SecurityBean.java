package co.com.techandsolve.aerotech.beans;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Inject;

import co.com.techandsolve.aerotech.daos.UsuarioDao;
import co.com.techandsolve.aerotech.models.Usuario;

public class SecurityBean {

	@Inject
	private UsuarioDao usuarioDao;

	private static final Map<String, Usuario> activeAutorizations = new ConcurrentHashMap<>();

	public Usuario login(String userName, String password) {

		List<Autorizacion> users = Arrays.asList(new Autorizacion(userName, password));

		return users.stream().filter(u -> checkPassword(u, password, userName)).map(this::generateToken).findAny()
				.orElseThrow(this::getLoginEx);
	}

	public Usuario loguot(String token) {
		return activeAutorizations.remove(token);
	}

	public RuntimeException getLoginEx() {

		return new RuntimeException("Credenciales de ingreso no validas.");
	}

	public boolean checkPassword(Autorizacion autorizacion, String password, String user) {
		List<Usuario>  listaUsuario = usuarioDao.consultarUsuarioPorEmailYPassword(user, password);
		return autorizacion.getUserName().equals(listaUsuario.get(0).getEmail())
				&& autorizacion.getPassword().equals(listaUsuario.get(0).getPassword());
	}

	public Usuario generateToken(Autorizacion autorizacion) {

		String token = UUID.randomUUID().toString();
		Usuario usuario = usuarioDao.consultarUsuarioPorAutorizacion(autorizacion);
		usuario.setToken(token);
		activeAutorizations.put(token, usuario);
		return usuario;
	}
}
