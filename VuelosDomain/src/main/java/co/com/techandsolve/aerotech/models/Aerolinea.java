package co.com.techandsolve.aerotech.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="aerolinea")
public class Aerolinea {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;

	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="idAerolinea" , cascade = CascadeType.ALL)
	private List<Avion> aviones=new ArrayList<Avion>();
	
	 

	public Aerolinea(){
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Avion> getAviones() {
		return aviones;
	}

	public void setAviones(List<Avion> aviones) {
		this.aviones = aviones;
	}
	
}
