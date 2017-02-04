package co.com.techandsolve.aerotech.models;

import java.util.ArrayList;
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
@Table(name="avion")
public class Avion {
	
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="cantidadSilla")
	private int cantidadSilla;
	
	@Column(name="placa")
	private String placa;
	
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="idAerolinea", referencedColumnName="id")
	private Aerolinea idAerolinea;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="idAvion" , cascade = CascadeType.ALL)
	private List<Vuelo> vuelos=new ArrayList<Vuelo>();

	
	public List<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public Avion(){
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public int getCantidadSilla() {
		return cantidadSilla;
	}


	public void setCantidadSilla(int cantidadSilla) {
		this.cantidadSilla = cantidadSilla;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public Aerolinea getIdAerolinea() {
		return idAerolinea;
	}


	public void setIdAerolinea(Aerolinea idAerolinea) {
		this.idAerolinea = idAerolinea;
	}

}
