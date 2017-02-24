package co.com.techandsolve.aerotech.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "vuelo")
@NamedQueries({
		@NamedQuery(name = Vuelo.BY_CITY, query = "select vuelo from Vuelo vuelo JOIN FETCH vuelo.idAvion where vuelo.origen= :origen AND vuelo.destino= :destino"),
		@NamedQuery(name = Vuelo.BY_ID, query = "select vuelo from Vuelo vuelo JOIN FETCH vuelo.idAvion where vuelo.id= :id") })
public class Vuelo {

	public static final String BY_CITY = "Busquedad de Vuelos por Ciudades";
	public static final String BY_ID = "Busquedad de Vuelos por ID";

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "fecha")
	private Date fecha;

	@Column(name = "origen")
	private String origen;

	@Column(name = "destino")
	private String destino;

	@Column(name = "tarifa")
	private double tarifa;

	@Column(name = "estado")
	private String estado;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idAvion", referencedColumnName = "id")
	private Avion idAvion;

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
