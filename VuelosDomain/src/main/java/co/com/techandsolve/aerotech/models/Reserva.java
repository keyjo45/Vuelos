package co.com.techandsolve.aerotech.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="reserva")
@NamedQueries({
	@NamedQuery(name=Reserva.BY_ID_USUARIO, query=" SELECT r FROM Reserva r JOIN FETCH r.idVuelo JOIN FETCH r.idUsuario usuario WHERE usuario.id=:id ")
})
public class Reserva {
	
	public static final String BY_ID_USUARIO="RESERVA_BY_ID_USUARIO";
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id; 
	
	@Column(name="fechaReserva")
	private Date fechaReserva;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="idVuelo", referencedColumnName="id")
	private Vuelo idVuelo;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="idUsuario", referencedColumnName="id")
	private Usuario idUsuario;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Vuelo getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(Vuelo idVuelo) {
		this.idVuelo = idVuelo;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

}
