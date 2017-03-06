package co.com.techandsolve.aerotech.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "usuario")
@NamedQueries({
		@NamedQuery(name = Usuario.BY_EMAIL, query = "SELECT usuario FROM Usuario as usuario WHERE usuario.email=:email AND usuario.password=:password"),
		@NamedQuery(name = Usuario.USUARIO_ENCONTRADO, query = "SELECT usuario FROM Usuario as usuario WHERE usuario.id=:id OR usuario.email=:email OR usuario.password=:password"),
		@NamedQuery(name = Usuario.BY_AUTORIZACION, query = "SELECT usuario FROM Usuario as usuario WHERE usuario.email=:email")})
public class Usuario {

	public static final String BY_AUTORIZACION = "USER_AUTORIZACION";
	public static final String USUARIO_ENCONTRADO = "USER_FIND";
	public static final String BY_EMAIL = "USER_FIND_BY_EMAIL_PASSWORD";

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "nombres")
	private String nombres;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name = "genero")
	private String genero;

	@Column(name = "telefono")
	private long telefono;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Transient
	private String token;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
