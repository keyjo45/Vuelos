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

	private List<Usuario> usuario;

	public Usuario login(String userName, String password) {

		List<Autorizacion> users = Arrays.asList(new Autorizacion(userName, password));

		return users.stream().filter(u -> checkPassword(u, password, userName)).map(this::generateToken).findAny()
				.orElseThrow(this::getLoginEx);
	}

	public void loguot(String token) {
		activeAutorizations.remove(token);
	}

	private RuntimeException getLoginEx() {

		return new RuntimeException("Credenciales de ingreso no validas.");
	}

	private boolean checkPassword(Autorizacion autorizacion, String password, String user) {
		usuario = usuarioDao.consultarUsuarioPorEmailYPassword(user, password);
		return autorizacion.getUserName().equals(usuario.get(0).getEmail())
				&& autorizacion.getPassword().equals(usuario.get(0).getPassword());
	}

	private Usuario generateToken(Autorizacion autorizacion) {
		final String token = UUID.randomUUID().toString();

		Usuario usu = new Usuario();
		usu.setId(usuario.get(0).getId());
		usu.setNombres(usuario.get(0).getNombres());
		usu.setApellidos(usuario.get(0).getApellidos());
		usu.setEmail(usuario.get(0).getEmail());
		usu.setFechaNacimiento(usuario.get(0).getFechaNacimiento());
		usu.setGenero(usuario.get(0).getGenero());
		usu.setTelefono(usuario.get(0).getTelefono());
		usu.setToken(token);
		activeAutorizations.put(token, usu);
		return usu;
	}

}
