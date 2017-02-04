package co.com.techandsolve.aerotech.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vuelo")
public class Vuelo {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="fecha")
	private Date fecha;
	
	@Column(name="origen")
	private String origen;
	
	@Column(name="destino")
	private String destino;
	
	@Column(name="tarifa")
	private double tarifa;
	
	@Column(name="estado")
	private String estado;
	

	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="idAvion", referencedColumnName="id")
	private Avion idAvion;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="idVuelo" , cascade = CascadeType.ALL)
	private List<Reserva> reservas=new ArrayList<Reserva>();
	

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public Avion getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(Avion idAvion) {
		this.idAvion = idAvion;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
